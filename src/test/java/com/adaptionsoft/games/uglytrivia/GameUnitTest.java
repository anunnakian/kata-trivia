package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class GameUnitTest {

  public static final String JULIE = "JULIE";
  private static final String JADE = "JADE";
  private static final String MORGANA = "Morgana";
  private static final String XENOLUNE = "Xenolune";
  private static final String LILITH = "Lilith";
  private static final String ELSA = "Elsa";
  private final Notifications notifications = mock(Notifications.class);
  private final Turn turn = mock(Turn.class);
  private final Answer answer = mock(Answer.class);

  private final Game game = new Game(turn, answer, notifications);

  @Test
  public void shouldAddPlayer() {
    assertThat(game.add(JULIE)).isTrue();
  }

  @Test
  public void shouldGetOnePlayer() {
    game.add(JULIE);

    verify(notifications).addPlayer(JULIE);
  }

  @Test
  public void shouldNotPlayableGameForOnePlayer() {
    game.add(JULIE);

    assertThat(game.isPlayable()).isFalse();
  }

  @Test
  public void shouldNotPlayableGameForSixPlayer() {
    gamePlayable();
    game.add(MORGANA);
    game.add(XENOLUNE);
    game.add(LILITH);
    game.add(ELSA);

    assertThat(game.isPlayable()).isFalse();
  }

  @Test
  public void shouldPlayableGameForFivePlayer() {
    gamePlayable();
    game.add(MORGANA);
    game.add(XENOLUNE);
    game.add(LILITH);

    assertThat(game.isPlayable()).isTrue();
  }

  @Test
  public void shouldPlayableGameForTwoPlayers() {
    gamePlayable();

    assertThat(game.isPlayable()).isTrue();
  }

  @Test
  public void shouldPlayableGameForThreePlayers() {
    gamePlayable();
    game.add(MORGANA);

    assertThat(game.isPlayable()).isTrue();
  }

  @Test
  public void shouldCheckNotifyAddPlayer() {
    game.add(JULIE);

    verify(notifications).addPlayer(JULIE);
    verify(notifications).playerPlace(1);
  }

  @Test
  public void shouldPlayTurnWithoutWinner() {
    Player julie = new Player(JULIE, 0);
    Player jade = new Player(JADE, 1);
    when(turn.tryToPlay(julie)).thenReturn(julie);
    when(turn.tryToPlay(jade)).thenReturn(jade);
    when(answer.answer(julie)).thenReturn(julie);
    when(answer.answer(jade)).thenReturn(jade);

    gamePlayable();
    assertThat(game.playTurn()).isFalse();
    assertThat(game.playTurn()).isFalse();

    ArgumentCaptor<Player> captor = ArgumentCaptor.forClass(Player.class);
    verify(turn, times(2)).tryToPlay(captor.capture());

    List<Player> players = captor.getAllValues();
    assertThat(players).extracting("name").containsExactly(JULIE, JADE);

    verify(notifications).askQuestion("Pop Question 0");
    verify(notifications).askQuestion("Pop Question 1");
    verify(answer, times(2)).answer(any(Player.class));
  }

  @Test
  public void shouldPlayTurnWithWinner() {
    Player julie = new Player(JULIE, 0);
    Player jade = new Player(JADE, 1);
    for (int i = 0; i < 6; i++) {
      jade = jade.addCoin();
    }
    when(turn.tryToPlay(julie)).thenReturn(julie);
    when(turn.tryToPlay(new Player(JADE, 1))).thenReturn(jade);
    when(answer.answer(julie)).thenReturn(julie);
    when(answer.answer(jade)).thenReturn(jade);

    gamePlayable();
    assertThat(game.playTurn()).isFalse();
    assertThat(game.playTurn()).isTrue();
  }

  private void gamePlayable() {
    game.add(JULIE);
    game.add(JADE);
  }
}
