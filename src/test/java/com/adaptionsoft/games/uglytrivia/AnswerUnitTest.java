package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class AnswerUnitTest {

  private final Notifications notifications = mock(Notifications.class);
  private final AnswerRandomSimulator randomSimulator = mock(AnswerRandomSimulator.class);

  @Test
  void shouldWrongAnswer() {
    Answer answer = new Answer(notifications, randomSimulator);
    when(randomSimulator.isRight()).thenReturn(false);
    Player player = player();

    assertThat(answer.answer(player).isInPenaltyBox()).isTrue();

    verify(notifications).incorrectlyAnswered();
    verify(notifications).sendInPenaltyBox(player.getName());
  }

  @Test
  void shouldCorrectAnswer() {
    Answer answer = new Answer(notifications, randomSimulator);
    when(randomSimulator.isRight()).thenReturn(true);
    Player player = player();

    player = answer.answer(player);
    assertThat(player.isInPenaltyBox()).isFalse();
    assertThat(player.getPurse()).isEqualTo(1);

    verify(notifications).correctAnswer();
    verify(notifications).actualGoldCoins(player.getName(), player.getPurse());
  }

  private Player player() {
    return new Player("Julie", 0);
  }
}
