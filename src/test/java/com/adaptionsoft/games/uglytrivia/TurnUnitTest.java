package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TurnUnitTest {

  static final int BOARD_LIMIT = 12;

  public static final String PLAYER_NAME = "Julie";
  private final Notifications notifications = mock(Notifications.class);
  private final Dice dice = mock(Dice.class);
  private final Turn turn = turn();

  @Test
  public void shouldPlayClassicTurn() {
    int roll = 1;
    when(dice.roll()).thenReturn(roll);
    Player player = turn.tryToPlay(player());

    assertThat(player.getPosition()).isEqualTo(1);
    assertThat(player.isInPenaltyBox()).isFalse();

    verify(notifications).roll(roll);
    verify(notifications).currentPlayer(PLAYER_NAME);
    verify(notifications).newLocation(PLAYER_NAME, roll);
    verify(notifications).currentCategory(Category.SCIENCE.getCategory());

    verify(notifications, never()).gettingOutOfPenaltyBox(PLAYER_NAME);
  }

  @Test
  public void shouldGettingOutOfPenaltyBox() {
    int roll = 1;
    when(dice.roll()).thenReturn(roll);
    Player player = player();
    player = player.inPenaltyBox();

    player = turn.tryToPlay(player);

    assertThat(player.isInPenaltyBox()).isFalse();

    verify(notifications).gettingOutOfPenaltyBox(PLAYER_NAME);
    verify(notifications).newLocation(PLAYER_NAME, roll);
    verify(notifications).currentCategory(Category.SCIENCE.getCategory());
  }

  @Test
  public void shouldNotGettingOutOfPenaltyBox() {
    int roll = 2;
    when(dice.roll()).thenReturn(roll);
    Player player = player();
    player = player.inPenaltyBox();

    player = turn.tryToPlay(player);
    assertThat(player.isInPenaltyBox()).isTrue();
    verify(notifications).notGettingOutOfPenaltyBox(PLAYER_NAME);
  }

  @Test
  public void shouldResetPosition() {
    when(dice.roll()).thenReturn(13);
    Player player = turn.tryToPlay(player());

    assertThat(player.getPosition()).isEqualTo(1);
    verify(notifications).newLocation(PLAYER_NAME, 1);
  }

  private Turn turn() {
    return new Turn(notifications, new Board(BOARD_LIMIT), dice);
  }

  private Player player() {
    return new Player(PLAYER_NAME, 0);
  }
}
