package service;

import model.Laptop;

import java.util.List;

public interface LaptopService {

    List<Laptop> getLaptops();

    void delLaptops(String name);

    void addLaptops(Laptop laptop);

    void updateLaptops(Laptop laptop);
}
