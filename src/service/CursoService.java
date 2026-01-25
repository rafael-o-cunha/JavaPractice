package service;

import java.util.*;

import domain.*;
import dao.*;

public class CursoService {

    private final CursoDao cursoDao;

    public CursoService(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    public void criarCursosIniciais(List<CursoDomain> cursos) {
        cursoDao.save(cursos.toArray(new CursoDomain[0]));
    }

    public Optional<CursoDomain> buscarPorId(Long id) {
        return cursoDao.findById(id);
    }

    public List<CursoDomain> listarTodos() {
        return cursoDao.findAll();
    }

    public long totalCursos() {
        return cursoDao.count();
    }
}
