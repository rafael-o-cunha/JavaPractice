package service;

import java.time.LocalDate;
import java.util.*;

import domain.*;
import dao.*;

public class DataLoaderService {

    private final CursoService cursoService;
    private final MentoriaService mentoriaService;
    private final BootcampService bootcampService;

    public DataLoaderService(CursoService cursoService, MentoriaService mentoriaService, BootcampService bootcampService) {
        this.cursoService = cursoService;
        this.mentoriaService = mentoriaService;
        this.bootcampService = bootcampService;
    }

    public void seed() {

        CursoDomain javaBasico = new CursoDomain(1L, "Java Básico", "Fundamentos", 20);
        CursoDomain javaAvancado = new CursoDomain(2L, "Java Avançado", "Streams", 60);
        cursoService.criarCursosIniciais(java.util.List.of(javaBasico, javaAvancado));

        MentoriaDomain arquitetura = new MentoriaDomain(3L, "Arquitetura", "Boas práticas", LocalDate.now().plusDays(10));
        mentoriaService.criarMentoriasIniciais(java.util.List.of(arquitetura));

        bootcampService.criarBootcamp(100L, "Bootcamp Java", "Formação completa", Set.of(), Set.of(javaBasico, javaAvancado, arquitetura));
    }
}
