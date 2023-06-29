package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Displayer;
import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Mock
    Displayer displayer;

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest(name = "{0} player(s)")
    public void should_add_player(int index) {
        Game game = new Game(displayer);

        for (int i = 1; i <= index; i++) {
            game.add("Play " + i);
        }

        for (int i = 1; i <= index; i++) {
            assertFalse(game.getInPenaltyBox()[i]);
            assertEquals(0, game.getPlaces()[i]);
            assertEquals(0, game.getPurses()[i]);

            InOrder inOrder = Mockito.inOrder(displayer);
            inOrder.verify(displayer).printLine("Play " + i + " was added");
            inOrder.verify(displayer).printLine("They are player number " + index);
        }
    }

    @Test
    public void should_throw_an_exception_when_add_6_players() {
        Game game = new Game(displayer);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 0; i < 6; i++) {
                game.add("Play " + i);
            }
        });
    }
}
