package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.List;

enum Category {
  POP("Pop", List.of(0, 4, 8)),
  SCIENCE("Science", List.of(1, 5, 9)),
  SPORTS("Sports", List.of(2, 6, 10)),
  ROCK("Rock", List.of());

  private final String category;
  private final List<Integer> positions;

  Category(String category, List<Integer> positions) {
    this.category = category;
    this.positions = positions;
  }

  static Category fromPosition(int position) {
    return Arrays.stream(Category.values()).filter(category -> category.positions.contains(position)).findFirst().orElse(Category.ROCK);
  }

  String getCategory() {
    return category;
  }
}
