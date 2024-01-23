package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckUnitTest {

  @Test
  void shouldRemoveOnceFirstPopQuestion() {
    assertThat(new Deck(1).removeFirstQuestion(Category.POP)).isEqualTo("Pop Question 0");
  }

  @Test
  void shouldRemoveTwiceFirstPopQuestion() {
    Deck deck = new Deck(2);

    deck.removeFirstQuestion(Category.POP);

    assertThat(deck.removeFirstQuestion(Category.POP)).isEqualTo("Pop Question 1");
  }

  @Test
  void shouldRemoveTwiceFirstScienceQuestion() {
    Deck deck = new Deck(2);

    deck.removeFirstQuestion(Category.SCIENCE);

    assertThat(deck.removeFirstQuestion(Category.SCIENCE)).isEqualTo("Science Question 1");
  }

  @Test
  void shouldRemoveSportsFirstScienceQuestion() {
    Deck deck = new Deck(2);

    deck.removeFirstQuestion(Category.SPORTS);

    assertThat(deck.removeFirstQuestion(Category.SPORTS)).isEqualTo("Sports Question 1");
  }

  @Test
  void shouldRemoveRockFirstScienceQuestion() {
    Deck deck = new Deck(2);

    deck.removeFirstQuestion(Category.ROCK);

    assertThat(deck.removeFirstQuestion(Category.ROCK)).isEqualTo("Rock Question 1");
  }
}
