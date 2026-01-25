package service;

import java.time.LocalDate;
import java.util.*;

import domain.*;
import dao.*;

public class MentoriaService {

    private final MentoriaDao mentoriaDao;

    public MentoriaService(MentoriaDao mentoriaDao) {
        this.mentoriaDao = mentoriaDao;
    }

    public void criarMentoriasIniciais(List<MentoriaDomain> mentorias) {
        mentoriaDao.save(mentorias.toArray(new MentoriaDomain[0]));
    }

    public List<MentoriaDomain> mentoriasFuturas() {
        return mentoriaDao.findAll(
            m -> m.getData().isAfter(LocalDate.now())
        );
    }

    public Optional<MentoriaDomain> buscarPorId(Long id) {
        return mentoriaDao.findById(id);
    }

    public long totalMentorias() {
        return mentoriaDao.count();
    }
}
