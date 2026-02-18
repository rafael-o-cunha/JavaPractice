package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.PlaceNumberUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlaceNumberUseCaseTest {
    @Test
    void shouldPlaceNumberSuccessfully() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        PlaceNumberUseCase useCase = new PlaceNumberUseCase(session);
        useCase.execute(0, 0, 5);

        assertEquals(new NumberValue(5), game.getBoard().getCell(new Position(0, 0)).getValue());
    }

    @Test
    void shouldUpdateStatusAfterMove() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        PlaceNumberUseCase useCase = new PlaceNumberUseCase(session);
        useCase.execute(0, 0, 5);

        assertFalse(game.getBoard().isComplete());
    }
}
