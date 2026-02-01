package domain;

import domain.ColaboradorDomain;
import domain.ATarefaDomain;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class ProjetoDomain implements IDomain<Long> {
    private final Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private SituacaoProjetoType situacao;
    private boolean ativo;
    private List<ATarefaDomain> tarefas;
    private List<ColaboradorDomain> colaboradores;

    // preservando inicialização de id, situação e estado
    private ProjetoDomain(){}
    
    public ProjetoDomain(Long id, String nome, String descricao) {
        this.id = id;
        this.situacao = SituacaoProjetoType.NAO_INICIADO;
        this.ativo = true;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefas = new ArrayList<>();
        this.colaboradores = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public SituacaoProjetoType getSituacao() {
        return this.situacao;
    }

    public void alterarSituacao(SituacaoProjetoType situacao) {
        this.situacao = situacao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public List<ATarefaDomain> getTarefas() {
        return Collections.unmodifiableList(this.tarefas);
    }

    public void adicionarTarefa(ATarefaDomain tarefa) {
        this.tarefas.add(tarefa);
    }

    public List<ColaboradorDomain> getColaboradores() {
        return Collections.unmodifiableList(this.colaboradores);
    }

    public void adicionarColaborador(ColaboradorDomain colaborador) {
        if (!colaboradores.contains(colaborador)) {
            colaboradores.add(colaborador);
        }
    }

    public void removerColaborador(ColaboradorDomain colaborador) {
        this.colaboradores.remove(colaborador);
    }

    public String toString() {
        String colaboradoresStr = this.colaboradores.stream()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", "));

        String tarefasStr = this.tarefas.stream()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", "));

        return "{ " + String.join(", ", 
            "Id: " + this.id,
            "Nome: " + this.nome,
            "Descricao: " + this.descricao,
            "Situacao: " + this.situacao.getDescricao(),
            "Ativo: " + this.ativo,
            "Data Início: " + this.dataInicio != null ? this.dataInicio.toString() : "N/A",
            "Data Fim: " + this.dataFim != null ? this.dataFim.toString() : "N/A",
            "Tarefas: [" + colaboradoresStr + "]",
            "Colaboradores: [" + tarefasStr + "]") + " }";
    }


}
