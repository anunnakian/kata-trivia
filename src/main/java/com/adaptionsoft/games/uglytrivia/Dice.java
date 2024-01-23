package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

class Dice {

  private final Random rand;

  public Dice(Random rand) {
    this.rand = rand;
  }

  public int roll() {
    return rand.nextInt(5) + 1;
  }
}
