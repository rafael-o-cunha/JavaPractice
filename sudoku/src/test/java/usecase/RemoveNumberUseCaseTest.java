package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.GameStatus;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.RemoveNumberUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveNumberUseCaseTest {

    @Test
    void shouldRemoveNumberSucessfully() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        RemoveNumberUseCase useCase = new RemoveNumberUseCase(session);
        useCase.execute(0, 0);

        assertTrue(game.getBoard().getCell(new Position(0, 0)).isEmpty());
    }

    @Test
    void shouldUpdateGameStatusAfterRemoval() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        RemoveNumberUseCase useCase = new RemoveNumberUseCase(session);
        useCase.execute(0, 0);

        assertEquals(GameStatus.INCOMPLETE, game.getGameStatus());
    }

}
