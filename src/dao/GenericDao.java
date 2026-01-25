package dao;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import domain.GenericDomain;

public abstract class GenericDao<ID, T extends GenericDomain<ID>> {
    
    protected final Map<ID, T> db = new HashMap<>();

    public List<T> findAll() {
        return new ArrayList<>(db.values());
    }

    public List<T> findAll(Predicate<T> filter) {
        return db.values()
                 .stream()
                 .filter(filter)
                 .collect(Collectors.toList());
    }

    public Optional<T> find(Predicate<T> filter) {
        return db.values()
                 .stream()
                 .filter(filter)
                 .findFirst();
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(db.get(id));
    }


    
    public T save(T domain) {
        Objects.requireNonNull(domain, "Domain não pode ser null");
        Objects.requireNonNull(domain.getId(), "ID não pode ser null");

        db.put(domain.getId(), domain);
        return domain;
    }

    @SafeVarargs
    public final List<T> save(T... domains) {
        return Arrays.stream(domains)
                .map(this::save)
                .collect(Collectors.toList());
    }

    
    
    public T update(ID id, T domain) {
        if (!db.containsKey(id)) {
            throw new NoSuchElementException("Registro não encontrado para ID: " + id);
        }

        db.put(id, domain);
        return domain;
    }

    
    
    public boolean deleteById(ID id) {
        return db.remove(id) != null;
    }

    public boolean delete(T domain) {
        return deleteById(domain.getId());
    }

    
    
    public boolean existsById(ID id) {
        return db.containsKey(id);
    }

    public int count() {
        return db.size();
    }

    public void clear() {
        db.clear();
    }
    
}
