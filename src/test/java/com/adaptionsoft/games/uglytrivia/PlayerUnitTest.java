package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerUnitTest {

  private static final String JULIE = "Julie";
  private static final String PLAYER = "Player";
  private static final String JADE = "Jade";

  @Test
  public void shouldCreatePlayer() {
    assertThat(player().getPosition()).isEqualTo(0);
    assertThat(player().getPurse()).isEqualTo(0);
    assertThat(player().getOrder()).isEqualTo(0);
  }

  @Test
  public void shouldGetPlayerName() {
    assertThat(player().getName()).isEqualTo(JULIE);
  }

  @Test
  public void shouldGetNewPlayerPosition() {
    Player player = player().position(1);

    assertThat(player.getPosition()).isEqualTo(1);
  }

  @Test
  public void shouldGetSecondNewPlayerPosition() {
    Player player = player().position(1).position(1);

    assertThat(player.getPosition()).isEqualTo(2);
  }

  @Test
  public void shouldResetPlayerPosition() {
    Player player = player().position(1).reset(1);

    assertThat(player.getPosition()).isEqualTo(0);
  }

  @Test
  public void shouldAddGoldCoin() {
    Player player = player().addCoin();

    assertThat(player.getPurse()).isEqualTo(1);
  }

  @Test
  public void shouldInPenalTyBox() {
    Player player = player().inPenaltyBox();
    assertThat(player.isInPenaltyBox()).isTrue();
  }

  @Test
  public void shouldOutPenalTyBox() {
    Player player = player().inPenaltyBox().outPenaltyBox();
    assertThat(player.isInPenaltyBox()).isFalse();
  }

  @Test
  public void shouldBeEqual() {
    assertThat(player().addCoin().equals(player())).isTrue();
  }

  @Test
  public void shouldNotBeEqualWhenNameIsDifferent() {
    assertThat(new Player(JADE, 0).equals(player())).isFalse();
  }

  @Test
  public void shouldNotBeEqualWhenOrderIsDifferent() {
    assertThat(new Player(JULIE, 1).equals(player())).isFalse();
  }

  @Test
  public void shouldGetSameHashCodeWithSamePlayer() {
    assertThat(player().hashCode()).isEqualTo(player().hashCode());
  }

  @Test
  public void shouldGetDifferentHashCodeWithDifferentPlayer() {
    assertThat(player().hashCode()).isNotEqualTo(new Player(PLAYER, 1).hashCode());
  }

  @Test
  public void shouldGetDifferentHashCodeWithDifferentName() {
    assertThat(player().hashCode()).isNotEqualTo(new Player(PLAYER, 0).hashCode());
  }

  @Test
  public void shouldGetDifferentHashCodeWithDifferentOrder() {
    assertThat(player().hashCode()).isNotEqualTo(new Player(JULIE, 1).hashCode());
  }

  private Player player() {
    return new Player(JULIE, 0);
  }
}
