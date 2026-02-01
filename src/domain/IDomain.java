package domain;

public interface IDomain<T> {
    
    T getId();

    boolean isAtivo();
    void desativar();
}
