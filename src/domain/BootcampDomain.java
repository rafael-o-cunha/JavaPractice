package domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class BootcampDomain implements GenericDomain<Long> {

    private Long id;
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<DevDomain> devsInscritos = new HashSet<>();
    private Set<ConteudoDomain> conteudos = new LinkedHashSet<>();

    public BootcampDomain() {
    }

    public BootcampDomain(Long id,
                          String nome,
                          String descricao,
                          Set<DevDomain> devsInscritos,
                          Set<ConteudoDomain> conteudos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.devsInscritos = devsInscritos;
        this.conteudos = conteudos;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<DevDomain> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<DevDomain> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<ConteudoDomain> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<ConteudoDomain> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BootcampDomain that = (BootcampDomain) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nome, that.nome) &&
               Objects.equals(descricao, that.descricao) &&
               Objects.equals(dataInicial, that.dataInicial) &&
               Objects.equals(dataFinal, that.dataFinal) &&
               Objects.equals(devsInscritos, that.devsInscritos) &&
               Objects.equals(conteudos, that.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

    @Override
    public String toString() {
        return "BootcampDomain{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", devsInscritos=" + devsInscritos +
                ", conteudos=" + conteudos +
                '}';
    }
}
