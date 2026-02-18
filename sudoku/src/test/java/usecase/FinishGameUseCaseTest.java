package usecase;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;
import com.rafaelocunha.sudoku.usecase.FinishGameUseCase;
import com.rafaelocunha.sudoku.usecase.GameSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinishGameUseCaseTest {

    SudokuValidator alwaysValid = new SudokuValidator() {
        public boolean isMoveValid(Board b, Position p) { return true; }
        public boolean isBoardValid(Board b) { return true; }
    };

    @Test
    void shouldFinishGameWhenCompleteAndValid() {
        Game game = new Game(alwaysValid);
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                game.getBoard().getCell(new Position(row, column)).setValue(new NumberValue((column % 9) + 1));
            }
        }

        FinishGameUseCase useCase = new FinishGameUseCase(session);
        useCase.execute();

        assertFalse(session.hasActiveGame());
    }

    @Test
    void shouldThrowExceptionIfGameNotComplete() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        FinishGameUseCase useCase = new FinishGameUseCase(session);

        assertThrows(RuntimeException.class, useCase::execute);
    }

}
