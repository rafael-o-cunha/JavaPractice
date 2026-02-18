package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameSessionTest {
    @Test
    void shouldStartNewGame() {
        Game game = new Game(new DefaultSudokuValidator());

        GameSession session = new GameSession();
        session.startNewGame(game);

        assertTrue(session.hasActiveGame());
        assertEquals(game, session.getCurrentGame());
    }

    @Test
    void shouldClearSession() {
        Game game = new Game(new DefaultSudokuValidator());

        GameSession session = new GameSession();
        session.startNewGame(game);
        session.clearSession();

        assertFalse(session.hasActiveGame());
    }
}
