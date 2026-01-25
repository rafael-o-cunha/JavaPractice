package service;

import java.time.LocalDate;
import java.util.*;

import domain.*;
import dao.*;

public class BootcampService {

    private final BootcampDao bootcampDao;

    public BootcampService(BootcampDao bootcampDao) {
        this.bootcampDao = bootcampDao;
    }

    
    public List<BootcampDomain> bootcampsComCursoLongo(int cargaMinima) {
        return bootcampDao.findAll(b ->
                b.getConteudos().stream()
                 .filter(CursoDomain.class::isInstance)
                 .map(CursoDomain.class::cast)
                 .anyMatch(c -> c.getCargaHoraria() >= cargaMinima)
        );
    }

    public List<BootcampDomain> bootcampsComMentoriaFutura() {
        return bootcampDao.findAll(b ->
                b.getConteudos().stream()
                 .filter(MentoriaDomain.class::isInstance)
                 .map(MentoriaDomain.class::cast)
                 .anyMatch(m -> m.getData().isAfter(LocalDate.now()))
        );
    }


    public BootcampDomain criarBootcamp(Long id, String nome, String descricao, Set<DevDomain> devs, Set<ConteudoDomain> conteudos) {
        BootcampDomain bootcamp = new BootcampDomain(id, nome, descricao, devs, conteudos);
        return bootcampDao.save(bootcamp);
    }


    public long totalBootcamps() {
        return bootcampDao.count();
    }
}
