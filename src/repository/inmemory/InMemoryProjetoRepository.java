package repository.inmemory;

import domain.IDomain;
import domain.ProjetoDomain;
import domain.type.SituacaoProjetoType;
import repository.interfaces.IProjetoRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryProjetoRepository implements IProjetoRepository {
    
    private final Map<Long, ProjetoDomain> tbProjetos;

    public InMemoryProjetoRepository(Map<Long, ProjetoDomain> tabela) {
        this.tbProjetos = Objects.requireNonNull(tabela, "Tabela não pode ser null");
    }

    @Override
    public ProjetoDomain save(ProjetoDomain domain) {
        Objects.requireNonNull(domain, "Domain não pode ser null");
        Objects.requireNonNull(domain.getId(), "ID não pode ser null");

        tbProjetos.put(domain.getId(), domain);
        return domain;
    }

    @Override
    public int count() {
        return this.findAll().size();
    }

    @Override
    public List<ProjetoDomain> findAll() {
        return tbProjetos.values().stream()
                            .filter(IDomain::isAtivo)
                            .collect(Collectors.toList());

    }

    @Override
    public Optional<ProjetoDomain> findById(Long id) {
        ProjetoDomain projeto = tbProjetos.get(id);
        return (projeto != null && projeto.isAtivo()) ? Optional.of(projeto) : Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        ProjetoDomain projeto = tbProjetos.get(id);
        return projeto != null && projeto.isAtivo();
    }
    
    @Override
    public boolean deleteById(Long id) {
        ProjetoDomain projeto = tbProjetos.get(id);
        if(projeto == null) return false;
        projeto.desativar();
        return true;
    }

    @Override
    public List<ProjetoDomain> findBySituacao(SituacaoProjetoType situacao) {
        Objects.requireNonNull(situacao);

        return tbProjetos.values().stream()
                            .filter(IDomain::isAtivo)
                            .filter(p -> p.getSituacao() == situacao)
                            .collect(Collectors.toList());
    }
    
    @Override
    public List<ProjetoDomain> findAtivosPorColaborador(Long colaboradorId) {
        Objects.requireNonNull(colaboradorId);

        return tbProjetos.values().stream()
                            .filter(IDomain::isAtivo)
                            .filter(p -> p.getColaboradores().stream()
                                        .anyMatch(c -> c.getId().equals(colaboradorId)))
                            .collector(Collectors.toList());
    }

}
