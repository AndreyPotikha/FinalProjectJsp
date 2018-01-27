package service.impl;

import dao.TableDao;
import dao.impl.TableDaoImpl;
import model.Table;
import service.TableService;

import java.util.List;

public class TableServiceImpl implements TableService {
    @Override
    public List<Table> getTable() {
        TableDao tableDao = new TableDaoImpl();
        return tableDao.getTable();
    }

    @Override
    public void delTable(String name) {
        TableDao tableDao = new TableDaoImpl();
        tableDao.delTable(name);
    }

    @Override
    public void addTable(Table table) {
        TableDao tableDao = new TableDaoImpl();
        tableDao.addTable(table);
    }

    @Override
    public void updateTable(Table table) {
        TableDao tableDao = new TableDaoImpl();
        tableDao.updateTable(table);
    }
}
