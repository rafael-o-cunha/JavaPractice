package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.ClearUserMovesUseCase;
import com.rafaelocunha.sudoku.usecase.GameSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClearUserMovesUseCaseTest {

    @Test
    void shouldClearOnlyUserMoves() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        ClearUserMovesUseCase useCase = new ClearUserMovesUseCase(session);
        useCase.execute();

        assertTrue(game.getBoard().getCell(new Position(0, 0)) .isEmpty());
    }

}
