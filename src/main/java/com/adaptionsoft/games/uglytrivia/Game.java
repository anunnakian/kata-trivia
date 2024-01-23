package com.adaptionsoft.games.uglytrivia;

class Game {

  static final int MAX_PLAYER_PLAYABLE = 6;
  static final int MAX_GOLD_COINS = 6;
  static final int MIN_PLAYER_PLAYABLE = 2;
  static final int LIMIT_DECK_SIZE = 50;
  private final Turn turn;
  private final Answer answer;
  private final Notifications notifications;
  private final Deck deck;

  private Players players;

  Game(Turn turn, Answer answer, Notifications notifications) {
    this.notifications = notifications;
    this.turn = turn;
    this.answer = answer;
    players = new Players();
    deck = new Deck(LIMIT_DECK_SIZE);
  }

  boolean isPlayable() {
    return minimumPlayer() && limitPlayersNotExceeded();
  }

  private boolean minimumPlayer() {
    return howManyPlayers() >= MIN_PLAYER_PLAYABLE;
  }

  private boolean limitPlayersNotExceeded() {
    return howManyPlayers() < MAX_PLAYER_PLAYABLE;
  }

  boolean add(String playerName) {
    players = players.add(playerName);

    notifications.addPlayer(playerName);
    notifications.playerPlace(howManyPlayers());

    return true;
  }

  private int howManyPlayers() {
    return players.howManyPlayers();
  }

  boolean playTurn() {
    updateCurrentPlayer(turn.tryToPlay(currentPlayer()));
    askQuestion();
    updateCurrentPlayer(answer.answer(currentPlayer()));

    if (didPlayerWin()) {
      return true;
    }

    players = players.nextPlayer();
    return false;
  }

  private boolean didPlayerWin() {
    return currentPlayer().getPurse() == MAX_GOLD_COINS;
  }

  private void updateCurrentPlayer(Player currentPlayer) {
    players = players.updateCurrentPlayer(currentPlayer);
  }

  private void askQuestion() {
    notifications.askQuestion(deck.removeFirstQuestion(currentCategory()));
  }

  private Category currentCategory() {
    return Category.fromPosition(currentPlayer().getPosition());
  }

  private Player currentPlayer() {
    return players.getCurrentPlayer();
  }
}
