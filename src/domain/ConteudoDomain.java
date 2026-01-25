package domain;

import java.util.Objects;

public abstract class ConteudoDomain implements GenericDomain<Long> {

    protected static final double XP_PADRAO = 10d;

    private Long id;
    private String titulo;
    private String descricao;

    public ConteudoDomain() {
    }

    public ConteudoDomain(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConteudoDomain that = (ConteudoDomain) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(titulo, that.titulo) &&
               Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao);
    }

    @Override
    public String toString() {
        return "ConteudoDomain{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
