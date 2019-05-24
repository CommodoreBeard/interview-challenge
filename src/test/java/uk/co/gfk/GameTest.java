package uk.co.gfk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    @Test public void firstGameTest() {
        Game game = new Game();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(14));
        cards.add(new Card(15));
        cards.add(new Card(7));
        cards.add(new Card(6));
        Wonder wonder = new Wonder(Arrays.asList(3, 5, 7));
        assertEquals("Test Test Failed", "Yes WWSS", game.playGame(wonder, cards));
    }
}
