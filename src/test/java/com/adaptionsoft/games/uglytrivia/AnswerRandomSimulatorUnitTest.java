package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class AnswerRandomSimulatorUnitTest {

  Random rand = mock(Random.class);

  @Test
  public void shouldCheckIsWrongAnswerForSeven() {
    AnswerRandomSimulator randomSimulator = new AnswerRandomSimulator(rand);

    when(rand.nextInt(9)).thenReturn(7);
    assertThat(randomSimulator.isRight()).isFalse();
  }

  @Test
  public void shouldCheckIsRightAnswerForMinSeven() {
    AnswerRandomSimulator randomSimulator = new AnswerRandomSimulator(rand);

    when(rand.nextInt(9)).thenReturn(6);
    assertThat(randomSimulator.isRight()).isTrue();
  }

  @Test
  public void shouldCheckIsRightAnswerForMoreSeven() {
    AnswerRandomSimulator randomSimulator = new AnswerRandomSimulator(rand);

    when(rand.nextInt(9)).thenReturn(8);
    assertThat(randomSimulator.isRight()).isTrue();
  }
}
