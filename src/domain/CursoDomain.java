package domain;

import java.util.Objects;

public class CursoDomain extends ConteudoDomain implements GenericDomain<Long> {

    private int cargaHoraria;

    public CursoDomain() {
        super();
    }

    public CursoDomain(Long id, String titulo, String descricao, int cargaHoraria) {
        super(id, titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CursoDomain that = (CursoDomain) o;
        return cargaHoraria == that.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargaHoraria);
    }

    @Override
    public String toString() {
        return "CursoDomain{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
