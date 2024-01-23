package com.adaptionsoft.games.uglytrivia;

class Board {

  private final int limitBoardSize;

  Board(int limitBoardSize) {
    this.limitBoardSize = limitBoardSize;
  }

  boolean isBeyondLimitBoard(int position) {
    return position >= limitBoardSize;
  }

  int getLimit() {
    return limitBoardSize;
  }
}
