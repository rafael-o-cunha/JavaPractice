package domain;

import java.util.*;
import java.util.stream.Collectors;

public class DefeitointernoDomain extends ATarefaDomain {
    private String impacto;
    private String moduloAfetado;

    //protege inicialização de attrs
    private DefeitoInternoDomain() {}

    public DefeitoInternoDomain(Long id,
                                String titulo,
                                String descricao,
                                OrigemTarefaType origem, 
                                SituacaoTarefaType situacao,
                                List<ColaboradorDomain> colaboradores,
                                String impacto,
                                String moduloAfetado
    ) {
        super(id, titulo, descricao, origem, situacao, colaboradores);
        this.impacto = impacto;
        this.moduloAfetado = moduloAfetado;
    }

    public TarefaType getTipo() {
        return TarefaType.DEFEITO_INTERNO;
    }

    public String getImpacto() {
        return this.impacto;
    }

    public void alterarImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getModuloAfetado(){
        return this.moduloAfetado;
    }

    public void alterarModuloAfetado(String moduloAfetado) {
        this.moduloAfetado = moduloAfetado;
    }

    @Override
    public String toString() {
        String colaboradoresStr = this.getColaboradores().stream()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", "));
        
        return "{ " + String.join(", ", 
            "Tipo: " + this.getTipo().getDescricao(),
            toStringBase(),
            "Impacto: " + this.impacto,
            "ModuloAfetado: " + this.moduloAfetado) + " }";
    }

}
1