package dao;

import model.Laptop;

import java.util.List;

public interface LaptopDao {

    List<Laptop> getLaptops();

    void delLaptops(String name);

    void addLaptops(Laptop laptop);

    void updateLaptops(Laptop laptop);
}
