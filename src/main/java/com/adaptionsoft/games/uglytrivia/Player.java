package com.adaptionsoft.games.uglytrivia;

import java.util.Optional;

class Player {

  private final String name;
  private final int position;
  private final int purse;
  private final boolean inPenaltyBox;
  private final int order;

  Player(String name, int order) {
    this.name = name;
    this.position = 0;
    this.purse = 0;
    this.inPenaltyBox = false;
    this.order = order;
  }

  private Player(PlayerBuilder builder) {
    name = builder.name;
    position = builder.position;
    purse = builder.purse;
    inPenaltyBox = builder.isInPenaltyBox;
    order = builder.order;
  }

  String getName() {
    return name;
  }

  int getPosition() {
    return position;
  }

  Player position(int position) {
    int newPosition = this.position + position;
    return buildNewPlayer(Optional.of(newPosition), Optional.empty(), Optional.empty());
  }

  Player reset(int borderBoard) {
    Integer newPosition = position - borderBoard;
    return buildNewPlayer(Optional.of(newPosition), Optional.empty(), Optional.empty());
  }

  int getPurse() {
    return purse;
  }

  Player addCoin() {
    return buildNewPlayer(Optional.empty(), Optional.of(this.purse + 1), Optional.empty());
  }

  boolean isInPenaltyBox() {
    return inPenaltyBox;
  }

  Player inPenaltyBox() {
    return buildNewPlayer(Optional.empty(), Optional.empty(), Optional.of(true));
  }

  Player outPenaltyBox() {
    return buildNewPlayer(Optional.empty(), Optional.empty(), Optional.of(false));
  }

  public int getOrder() {
    return order;
  }

  private Player buildNewPlayer(Optional<Integer> position, Optional<Integer> purse, Optional<Boolean> inPenaltyBox) {
    return new PlayerBuilder()
      .name(name)
      .position(position.orElse(this.position))
      .purse(purse.orElse(this.purse))
      .isInPenaltyBox(inPenaltyBox.orElse(this.inPenaltyBox))
      .order(order)
      .build();
  }

  private static class PlayerBuilder {

    private String name;
    private int position;
    private int purse;
    private boolean isInPenaltyBox;
    private int order;

    PlayerBuilder name(String name) {
      this.name = name;

      return this;
    }

    PlayerBuilder position(int position) {
      this.position = position;

      return this;
    }

    PlayerBuilder purse(int purse) {
      this.purse = purse;

      return this;
    }

    PlayerBuilder isInPenaltyBox(boolean isInPenaltyBox) {
      this.isInPenaltyBox = isInPenaltyBox;

      return this;
    }

    PlayerBuilder order(int order) {
      this.order = order;

      return this;
    }

    Player build() {
      return new Player(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return name.equals(player.name) && order == player.getOrder();
  }

  @Override
  public int hashCode() {
    return name.hashCode() + order;
  }
}
