package service.impl;

import dao.LaptopDao;
import dao.impl.LaptopDaoImpl;
import model.Laptop;
import service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    @Override
    public List<Laptop> getLaptops() {
        LaptopDao laptopDao = new LaptopDaoImpl();
        return laptopDao.getLaptops();
    }

    @Override
    public void delLaptops(String name) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.delLaptops(name);
    }

    @Override
    public void addLaptops(Laptop laptop) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.addLaptops(laptop);
    }

    @Override
    public void updateLaptops(Laptop laptop) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.updateLaptops(laptop);
    }
}
