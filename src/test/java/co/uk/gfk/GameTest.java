package co.uk.gfk;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test public void firstGameTest() {
        Game game = new Game();
        assertEquals("Test Test Failed", "Yes WWSS", game.playGame());
    }
}
