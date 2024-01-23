package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryUnitTest {

  @Test
  void shouldGetPopCategory() {
    Assertions.assertThat(Category.POP.getCategory()).isEqualTo("Pop");
  }

  @Test
  void shouldGetNullCategoryForUnknownPosition() {
    assertThat(Category.fromPosition(50).getCategory()).isEqualTo("Rock");
  }

  @Test
  void shouldGetCategoryWithPositionZero() {
    assertThat(Category.fromPosition(0).getCategory()).isEqualTo("Pop");
  }

  @Test
  void shouldGetCategoryWithPositionOne() {
    assertThat(Category.fromPosition(1).getCategory()).isEqualTo("Science");
  }
}
