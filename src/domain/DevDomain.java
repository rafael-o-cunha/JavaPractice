package domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class DevDomain implements GenericDomain<Long> {

    private Long id;
    private String nome;
    private Set<ConteudoDomain> conteudosInscritos = new LinkedHashSet<>();
    private Set<ConteudoDomain> conteudosConcluidos = new LinkedHashSet<>();

    public DevDomain() {
    }

    public DevDomain(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Set<ConteudoDomain> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<ConteudoDomain> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<ConteudoDomain> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<ConteudoDomain> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevDomain dev = (DevDomain) o;
        return Objects.equals(id, dev.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DevDomain{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", inscritos=" + conteudosInscritos.size() +
                ", concluidos=" + conteudosConcluidos.size() +
                '}';
    }
}
