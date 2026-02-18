package com.rafaelocunha.sudoku.app;

import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.usecase.*;

public class ApplicationFactory {
    private final GameSession session;
    private final DefaultSudokuValidator validator;

    private final StartGameUseCase startUC;
    private final PlaceNumberUseCase placeUC;
    private final RemoveNumberUseCase removeUC;
    private final GetBoardStateUseCase boardUC;
    private final GetGameStatusUseCase statusUC;
    private final ClearUserMovesUseCase clearUC;
    private final FinishGameUseCase finishUC;

    public ApplicationFactory() {

        this.session = new GameSession();
        this.validator = new DefaultSudokuValidator();

        this.startUC = new StartGameUseCase(session, validator);
        this.placeUC = new PlaceNumberUseCase(session);
        this.removeUC = new RemoveNumberUseCase(session);
        this.boardUC = new GetBoardStateUseCase(session);
        this.statusUC = new GetGameStatusUseCase(session);
        this.clearUC = new ClearUserMovesUseCase(session);
        this.finishUC = new FinishGameUseCase(session);
    }

    public StartGameUseCase start() { return startUC; }
    public PlaceNumberUseCase place() { return placeUC; }
    public RemoveNumberUseCase remove() { return removeUC; }
    public GetBoardStateUseCase board() { return boardUC; }
    public GetGameStatusUseCase status() { return statusUC; }
    public ClearUserMovesUseCase clear() { return clearUC; }
    public FinishGameUseCase finish() { return finishUC; }
}
