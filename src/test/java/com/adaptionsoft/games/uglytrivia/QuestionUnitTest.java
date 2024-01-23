package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuestionUnitTest {

  @Test
  public void shouldCreateQuestion() {
    assertThat(new Question(Category.POP, 0)).isNotNull();
  }

  @Test
  public void shouldGetMessageForPopCategory() {
    Question question = new Question(Category.POP, 0);
    assertThat(question.getMessage()).isEqualTo("Pop Question 0");
  }

  @Test
  public void shouldGetMessageScienceCategory() {
    assertThat(new Question(Category.SCIENCE, 1).getMessage()).isEqualTo("Science Question 1");
  }
}
