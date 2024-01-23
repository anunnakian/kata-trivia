package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

class AnswerRandomSimulator {

  private final Random rand;

  AnswerRandomSimulator(Random rand) {
    this.rand = rand;
  }

  boolean isRight() {
    return !(rand.nextInt(9) == 7);
  }
}
