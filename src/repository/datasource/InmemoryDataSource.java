package repository.datasource;

import java.util.Map;
import java.util.HashMap;

public class InmemoryDataSource {
    
    private final Map<String, Map<Long, Object>> database = new HashMap<>();

    public <T> Map<Long, T> getTabela(String nomeTabela) {
        return (Map<Long, T>) database.computeIfAbsent(nomeTabela, k -> new HashMap<>());
    }

    public boolean tabelaExists(String nomeTabela) {
        return database.containsKey(nomeTabela);
    }

    public void clear() {
        database.clear();
    }
}
