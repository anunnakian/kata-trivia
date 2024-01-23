package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayersUnitTest {

  static final String PLAYER_NAME = "Julie";
  private static final String JADE = "Jade";

  @Test
  void shouldAddPlayer() {
    Player player = new Players().add(PLAYER_NAME).get(0);
    assertThat(player.getName()).isEqualTo(PLAYER_NAME);
    assertThat(player.getOrder()).isEqualTo(0);
  }

  @Test
  void shouldGetHowManyPlayers() {
    Players players = new Players().add(PLAYER_NAME);

    assertThat(players.howManyPlayers()).isEqualTo(1);
  }

  @Test
  void shouldGetCurrentPlayer() {
    Players players = new Players().add(PLAYER_NAME).add(JADE).nextPlayer();
    assertThat(players.getCurrentPlayer().getName()).isEqualTo(JADE);
  }

  @Test
  void shouldGetFirstPlayerWhenNoNextPlayer() {
    Players players = new Players().add(PLAYER_NAME).add(JADE).nextPlayer().nextPlayer();
    assertThat(players.getCurrentPlayer().getName()).isEqualTo(PLAYER_NAME);
  }

  @Test
  void shouldUpdateCurrentPlayer() {
    Players players = new Players().add(PLAYER_NAME);
    Player currentPlayer = player().addCoin().inPenaltyBox();

    currentPlayer = players.updateCurrentPlayer(currentPlayer).getCurrentPlayer();
    assertThat(currentPlayer.getPurse()).isEqualTo(1);
    assertThat(currentPlayer.isInPenaltyBox()).isTrue();
  }

  private Player player() {
    return new Player(PLAYER_NAME, 0);
  }
}
