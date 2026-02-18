package usecase;

import com.rafaelocunha.sudoku.domain.model.GameStatus;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.StartGameUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartGameUseCaseTest {

    @Test
    void shouldCreateAndStartGame() {
        GameSession session = new GameSession();
        StartGameUseCase useCase = new StartGameUseCase(session, new DefaultSudokuValidator());

        useCase.execute();

        assertTrue(session.hasActiveGame());
        assertEquals(GameStatus.INCOMPLETE, session.getCurrentGame().getGameStatus());
    }
}
