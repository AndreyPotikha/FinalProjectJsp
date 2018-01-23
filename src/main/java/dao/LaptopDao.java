package dao;

import model.Laptop;

import java.util.List;

public interface LaptopDao {

    void getLaptops();

    void delLaptops(Laptop laptop);

    void addLaptops(Laptop laptop);

    void updateLaptops(Laptop laptop);
}
