package dao;

import javafx.scene.control.Tab;
import model.Phone;
import model.Table;

import java.util.List;

public interface TableDao {

    List<Table> getTable();

    void delTable(Table table);

    void addTable(Table table);

    void updateTable(Table table);
}
