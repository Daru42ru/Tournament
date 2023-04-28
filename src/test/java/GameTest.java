import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.NotDirectoryException;

public class GameTest {
    @Test
    public void whenPlayerOneWin() {
        Player kolya = new Player(1, "Коля", 150);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 1;
        int actual = game.round("Коля","Петя");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerTwoWin() {
        Player kolya = new Player(1, "Коля", 150);
        Player petya = new Player(2, "Петя", 170);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 2;
        int actual = game.round("Коля","Петя");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenNobodyWin() {
        Player kolya = new Player(1, "Коля", 150);
        Player petya = new Player(2, "Петя", 150);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 0;
        int actual = game.round("Коля","Петя");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerOneNotExist() {
        Player kolya = new Player(1, "Коля", 150);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Кирилл", "Петя"));
    }
    @Test
    public void whenPlayerTwoNotExist() {
        Player kolya = new Player(1, "Коля", 150);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Коля", "Кирилл"));
    }
}
