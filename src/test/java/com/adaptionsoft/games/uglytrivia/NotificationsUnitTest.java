package com.adaptionsoft.games.uglytrivia;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class NotificationsUnitTest {

  private static final String JULIE = "Julie";
  private final ConsolePrinter printer = mock(ConsolePrinter.class);
  private final Notifications notifications = new Notifications(printer);

  @Test
  void shouldNotifyAddPlayer() {
    notifications.addPlayer(JULIE);
    verify(printer).sendMessage("Julie was added");
  }

  @Test
  void shouldNotifyPlayerPlace() {
    notifications.playerPlace(1);
    verify(printer).sendMessage("They are player number 1");
  }

  @Test
  void shouldNotifyCurrentPlayer() {
    notifications.currentPlayer(JULIE);
    verify(printer).sendMessage("Julie is the current player");
  }

  @Test
  void shouldNotifyRoll() {
    notifications.roll(1);
    verify(printer).sendMessage("They have rolled a 1");
  }

  @Test
  void shouldNotifyNotGettingOutPenaltyBox() {
    notifications.notGettingOutOfPenaltyBox(JULIE);
    verify(printer).sendMessage("Julie is not getting out of the penalty box");
  }

  @Test
  void shouldNotifyNewLocation() {
    notifications.newLocation(JULIE, 1);
    verify(printer).sendMessage("Julie's new location is 1");
  }

  @Test
  void shouldNotifyCurrentCategory() {
    notifications.currentCategory("Pop");
    verify(printer).sendMessage("The category is Pop");
  }

  @Test
  void shouldNotifyGettingOutPenaltyBox() {
    notifications.gettingOutOfPenaltyBox(JULIE);
    verify(printer).sendMessage("Julie is getting out of the penalty box");
  }

  @Test
  void shouldNotifyCorrectAnswer() {
    notifications.correctAnswer();
    verify(printer).sendMessage("Answer was correct!!!!");
  }

  @Test
  void shouldNotifyActualGoldCoins() {
    notifications.actualGoldCoins(JULIE, 1);
    verify(printer).sendMessage("Julie now has 1 Gold Coins.");
  }

  @Test
  void shouldNotifyIncorrectlyAnswered() {
    notifications.incorrectlyAnswered();
    verify(printer).sendMessage("Question was incorrectly answered");
  }

  @Test
  void shouldNotifySendInPenaltyBox() {
    notifications.sendInPenaltyBox(JULIE);
    verify(printer).sendMessage("Julie was sent to the penalty box");
  }

  @Test
  void shouldAskQuestion() {
    notifications.askQuestion("question");
    verify(printer).sendMessage("question");
  }
}
