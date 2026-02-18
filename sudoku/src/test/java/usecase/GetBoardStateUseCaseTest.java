package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.GetBoardStateUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBoardStateUseCaseTest {

    @Test
    void shouldReturnCorrectBoardState() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        GetBoardStateUseCase useCase = new GetBoardStateUseCase(session);

        int [][] state = useCase.execute();

        assertEquals(5, state[0][0]);
        assertEquals(0, state[0][1]);
    }

}
