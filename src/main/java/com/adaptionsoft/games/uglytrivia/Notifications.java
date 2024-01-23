package com.adaptionsoft.games.uglytrivia;

public class Notifications {

  private final ConsolePrinter printer;

  public Notifications(ConsolePrinter printer) {
    this.printer = printer;
  }

  void addPlayer(String player) {
    printer.sendMessage(player + " was added");
  }

  void playerPlace(int place) {
    printer.sendMessage("They are player number " + place);
  }

  void currentPlayer(String player) {
    printer.sendMessage(player + " is the current player");
  }

  void roll(int roll) {
    printer.sendMessage("They have rolled a " + roll);
  }

  void notGettingOutOfPenaltyBox(String player) {
    printer.sendMessage(player + " is not getting out of the penalty box");
  }

  void newLocation(String player, int location) {
    printer.sendMessage(player + "'s new location is " + location);
  }

  void currentCategory(String category) {
    printer.sendMessage("The category is " + category);
  }

  void gettingOutOfPenaltyBox(String player) {
    printer.sendMessage(player + " is getting out of the penalty box");
  }

  void correctAnswer() {
    printer.sendMessage("Answer was correct!!!!");
  }

  void actualGoldCoins(String player, int goldCoins) {
    printer.sendMessage(player + " now has " + goldCoins + " Gold Coins.");
  }

  void incorrectlyAnswered() {
    printer.sendMessage("Question was incorrectly answered");
  }

  void sendInPenaltyBox(String player) {
    printer.sendMessage(player + " was sent to the penalty box");
  }

  void askQuestion(String question) {
    printer.sendMessage(question);
  }
}
