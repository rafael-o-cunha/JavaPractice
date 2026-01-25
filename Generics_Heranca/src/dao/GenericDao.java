package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import domain.GenericDomain;

public abstract class GenericDao<ID, T extends GenericDomain<ID>> {
    
    public final List<T> db = new ArrayList<>();

    public List<T> findAll() {
        return db;
    }

    public Optional<T> find(Predicate<T> filter) {
        return db.stream().filter(filter).findFirst();
    }

    public T save(T domain) {
        db.add(domain);
        return domain;
    }

    public T update(ID id, T domain) {
        var stored = find(d -> d.getId().equals(domain.getId())).orElseThrow();
        delete(stored);
        return save(domain);
    }

    public boolean delete(T domain) {
        return db.remove(domain);
    }

    public int count() {
        return db.size();
    }
    
}
