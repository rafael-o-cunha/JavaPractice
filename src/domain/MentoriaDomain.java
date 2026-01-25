package domain;

import java.time.LocalDate;
import java.util.Objects;

public class MentoriaDomain extends ConteudoDomain implements GenericDomain<Long> {

    private LocalDate data;

    public MentoriaDomain() {
        super();
    }

    public MentoriaDomain(Long id, String titulo, String descricao, LocalDate data) {
        super(id, titulo, descricao);
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MentoriaDomain that = (MentoriaDomain) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data);
    }

    @Override
    public String toString() {
        return "MentoriaDomain{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}
