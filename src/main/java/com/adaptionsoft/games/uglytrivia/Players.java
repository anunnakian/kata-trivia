package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Players {

  private final List<Player> players;
  private int currentPlayer;

  Players() {
    this.players = new ArrayList<>();
  }

  Players(List<Player> players, int currentPlayer) {
    this.players = players.stream().sorted(Comparator.comparing(Player::getOrder)).collect(Collectors.toUnmodifiableList());
    this.currentPlayer = currentPlayer;
  }

  Players add(String playerName) {
    List<Player> newPlayers = new ArrayList<>(players);
    newPlayers.add(new Player(playerName, players.size()));

    return new Players(newPlayers, currentPlayer);
  }

  Player get(int index) {
    return players.get(index);
  }

  int howManyPlayers() {
    return players.size();
  }

  Player getCurrentPlayer() {
    return players.get(currentPlayer);
  }

  Players nextPlayer() {
    currentPlayer++;
    if (isExceededLimitPlayers(currentPlayer)) {
      currentPlayer = 0;
    }

    return new Players(players, currentPlayer);
  }

  private boolean isExceededLimitPlayers(int index) {
    return index >= players.size();
  }

  Players updateCurrentPlayer(Player player) {
    List<Player> newPlayers = new ArrayList<>(players);
    newPlayers.remove(currentPlayer);
    newPlayers.add(player);
    return new Players(newPlayers, currentPlayer);
  }
}
