package com.adaptionsoft.games.uglytrivia;

class Turn {

  private final Notifications notifications;
  private final Board board;
  private final Dice dice;

  Turn(Notifications notifications, Board board, Dice dice) {
    this.notifications = notifications;
    this.board = board;
    this.dice = dice;
  }

  Player tryToPlay(Player player) {
    int roll = dice.roll();

    notifications.currentPlayer(player.getName());
    notifications.roll(roll);

    if (canNotGettingOutOfPenaltyBox(player, roll)) {
      notifications.notGettingOutOfPenaltyBox(player.getName());
      return player;
    }

    return playTurn(player, roll);
  }

  private Player playTurn(Player player, int roll) {
    player = inPenaltyBox(player);

    player = move(player, roll);

    notifications.newLocation(player.getName(), player.getPosition());
    notifications.currentCategory(currentCategory(player).getCategory());

    return player;
  }

  private Player inPenaltyBox(Player player) {
    if (player.isInPenaltyBox()) {
      player = player.outPenaltyBox();
      notifications.gettingOutOfPenaltyBox(player.getName());
    }
    return player;
  }

  private Player move(Player player, int roll) {
    return resetPlayerPosition(player.position(roll));
  }

  private Player resetPlayerPosition(Player player) {
    if (board.isBeyondLimitBoard(player.getPosition())) {
      return player.reset(board.getLimit());
    }

    return player;
  }

  private Category currentCategory(Player player) {
    return Category.fromPosition(player.getPosition());
  }

  private boolean canNotGettingOutOfPenaltyBox(Player player, int roll) {
    return player.isInPenaltyBox() && isPairRoll(roll);
  }

  private boolean isPairRoll(int roll) {
    return roll % 2 == 0;
  }
}
