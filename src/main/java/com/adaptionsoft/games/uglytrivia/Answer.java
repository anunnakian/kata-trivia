package com.adaptionsoft.games.uglytrivia;

public class Answer {

  private final Notifications notifications;
  private final AnswerRandomSimulator answerRandom;

  public Answer(Notifications notifications, AnswerRandomSimulator answerRandom) {
    this.notifications = notifications;
    this.answerRandom = answerRandom;
  }

  public Player answer(Player player) {
    if (!answerRandom.isRight()) {
      return wrongAnswer(player);
    }

    return goodAnswer(player);
  }

  private Player goodAnswer(Player player) {
    if (!player.isInPenaltyBox()) {
      notifications.correctAnswer();
      player = player.addCoin();
      notifications.actualGoldCoins(player.getName(), player.getPurse());
    }
    return player;
  }

  private Player wrongAnswer(Player player) {
    notifications.incorrectlyAnswered();
    notifications.sendInPenaltyBox(player.getName());
    return player.inPenaltyBox();
  }
}
