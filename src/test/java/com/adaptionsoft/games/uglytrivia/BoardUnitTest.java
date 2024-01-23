package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardUnitTest {

  static final int BOARD_LIMIT = 10;
  private final Board board = new Board(BOARD_LIMIT);

  @Test
  void shouldNotBeBeyondLimit() {
    assertThat(board.isBeyondLimitBoard(9)).isFalse();
  }

  @Test
  void shouldBeBeyondLimit() {
    assertThat(board.isBeyondLimitBoard(12)).isTrue();
  }

  @Test
  void shouldGetLimit() {
    assertThat(board.getLimit()).isEqualTo(BOARD_LIMIT);
  }
}
