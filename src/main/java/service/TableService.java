package service;

import model.Table;

import java.util.List;

public interface TableService {

    List<Table> getTable();

    void delTable(String name);

    void addTable(Table table);

    void updateTable(Table table);

}
