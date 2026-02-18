package usecase.dto;

public record CellState (Integer value, boolean fixed) {

    public boolean isEmpty() {
        return value == null;
    }
}
