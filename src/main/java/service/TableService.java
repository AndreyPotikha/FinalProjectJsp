package service;

import model.Table;

import java.util.List;

public interface TableService {

    List<Table> getTable();

    void delTable(Table table);

    void addTable(Table table);

    void updateTable(Table table);

}
