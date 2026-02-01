package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public abstract class ATarefaDomain implements IDomain<Long> {
    protected final Long id;
    protected boolean ativo;
    protected String titulo;
    protected String descricao;
    protected OrigemTarefaType origem;
    protected SituacaoTarefaType situacao;
    protected final List<ColaboradorDomain> colaboradores;
    protected LocalDateTime dataInicio;
    protected LocalDateTime dataFim;

    protected ATarefaDomain(Long id,
                            String titulo,
                            String descricao,
                            OrigemTarefaType origem,
                            SituacaoTarefaType situacao,
                            List<ColaboradorDomain> colaboradores) {
        this.id = id;
        this.ativo = true;
        this.titulo = titulo;
        this.descricao = descricao;
        this.origem = origem;
        this.situacao = situacao;
        this.colaboradores = new ArrayList<>(colaboradores);
    }

    public Long getId() {
        return this.id;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public abstract TarefaType getTipo();

    protected String getTitulo() {
        return this.titulo;
    }

    protected void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    protected String getDescricao() {
        return this.descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected OrigemTarefaType getOrigem() {
        return this.origem;
    }

    protected void setOrigem(OrigemTarefaType origem) {
        this.origem = origem;
    }

    protected SituacaoTarefaType getSituacao() {
        return this.situacao;
    }

    protected void setSituacao(SituacaoTarefaType situacao) {
        this.situacao = situacao;
    }

    protected List<ColaboradorDomain> getColaboradores() {
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

    protected LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    protected void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    protected LocalDateTime getDataFim() {
        return this.dataFim;
    }

    protected void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String toString() {
        return toStringBase();
    }

    protected String toStringBase() {
        String colaboradoresStr = colaboradores.stream()
                                                .map(Object::toString)
                                                .collect(Collectors.joining(", "));

        return String.join(", ",
            "Id: " + this.id,
            "Titulo: " + this.titulo,
            "Descricao: " + this.descricao,
            "Origem: " + this.origem.getDescricao(),
            "Situacao: " + this.situacao.getDescricao(),
            "Ativo: " + this.ativo,
            "Data Início: " + (this.dataInicio != null ? this.dataInicio : "N/A"), 
            "Data Fim: " + (this.dataFim != null ? this.dataFim : "N/A"),
            "Colaboradores: [" + colaboradoresStr + "]" );
    }

}
