package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Deck {

  Map<Category, LinkedList<Question>> deck;

  Deck(int limitDeckSize) {
    deck = new HashMap<>();

    deck.put(Category.POP, new LinkedList<>());
    deck.put(Category.SCIENCE, new LinkedList<>());
    deck.put(Category.SPORTS, new LinkedList<>());
    deck.put(Category.ROCK, new LinkedList<>());

    for (int i = 0; i < limitDeckSize; i++) {
      deck.get(Category.POP).addLast(new Question(Category.POP, i));
      deck.get(Category.SCIENCE).addLast(new Question(Category.SCIENCE, i));
      deck.get(Category.SPORTS).addLast(new Question(Category.SPORTS, i));
      deck.get(Category.ROCK).addLast(new Question(Category.ROCK, i));
    }
  }

  String removeFirstQuestion(Category category) {
    return deck.get(category).removeFirst().getMessage();
  }
}
