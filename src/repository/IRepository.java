package repository;

import java.util.*;

public interface IRepository<T, ID> {
    T save(T domain);
    int count();
    List<T> findAll();
    Optional<T> findById(ID id);
    boolean existsById(ID id);
    boolean deleteById(ID id);
}
