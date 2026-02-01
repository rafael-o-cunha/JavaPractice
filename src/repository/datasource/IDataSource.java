package repository.datasource;

public java.util.Map;

public interface IDataSource {
    <ID, T> Map<ID, T> getTable(String tableName);
}
