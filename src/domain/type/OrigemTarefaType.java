package domain.type;

public enum OrigemTarefaType {
    INTERNA("Origem interna da equipe"),
    EXTERNA("Origem externa, cliente ou usuário"),
    NEGOCIO("Demanda de negócio"),
    TECNICA("Demanda técnica");

    private final String descricao;

    OrigemTarefaType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static OrigemTarefaType getType(String typeName) {
        return values().stream()
                        .filter(e -> e.name().equals(typeName))
                        .findFirst()
                        .orElse(null);
    }
}
