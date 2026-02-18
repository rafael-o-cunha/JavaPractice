package usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.GameStatus;
import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.GameSession;
import com.rafaelocunha.sudoku.usecase.GetGameStatusUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetGameStatusUseCaseTest {

    @Test
    void shouldReturnCurrentGameStatus() {
        Game game = new Game(new DefaultSudokuValidator());
        game.start();

        GameSession session = new GameSession();
        session.startNewGame(game);

        GetGameStatusUseCase useCase = new GetGameStatusUseCase(session);

        assertEquals(GameStatus.INCOMPLETE, useCase.execute());
    }

}
