package repository;

import domain.ProjetoDomain;
import domain.type.SituacaoProjetoType;

import java.util.*;

public interface IProjetoRepository extends IRepository<ProjetoDomain, Long> {
    
    List<ProjetoDomain> findBySituacao(SituacaoProjetoType situacao);
    
    List<ProjetoDomain> findAtivosPorColaborador(Long colaboradorId);
}
