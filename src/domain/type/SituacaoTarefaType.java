package domain.type;

public enum SituacaoTarefaType {
    ABERTA("Tarefa criada e aguardando início"),
    EM_PROGRESSO("Tarefa em execução"),
    PAUSADA("Tarefa pausada"),
    BLOQUEADA("Tarefa com impedimento"),
    CONCLUIDA("Tarefa finalizada com sucesso"),
    CANCELADA("Tarefa cancelada");

    private final String descricao;

    SituacaoTarefaType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static SituacaoTarefaType getType(String typeName) {
        return values().stream()
                        .filter(e -> e.name().equals(typeName))
                        .findFirst()
                        .orElse(null);
    }
}
