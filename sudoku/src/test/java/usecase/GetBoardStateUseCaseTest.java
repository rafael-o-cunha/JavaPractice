package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.GetBoardStateUseCase;
import com.rafaelocunha.sudoku.usecase.dto.BoardState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetBoardStateUseCaseTest {

    @Test
    void shouldReturnCorrectBoardState() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        GetBoardStateUseCase useCase = new GetBoardStateUseCase(session);

        BoardState state = useCase.execute();

        assertEquals(5, state.grid()[0][0].value());
        assertNull(state.grid()[0][1].value());
        assertFalse(state.grid()[0][0].isEmpty());
        assertTrue(state.grid()[0][1].isEmpty());
    }

}
