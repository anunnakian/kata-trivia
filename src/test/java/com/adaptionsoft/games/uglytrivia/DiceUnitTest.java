package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class DiceUnitTest {

  Random rand = mock(Random.class);

  @Test
  public void shouldRollDice() {
    Dice dice = new Dice(rand);
    when(rand.nextInt(5)).thenReturn(2);
    assertThat(dice.roll()).isEqualTo(3);
  }
}
