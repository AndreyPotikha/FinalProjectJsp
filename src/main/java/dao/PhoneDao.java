package dao;

import model.Laptop;
import model.Phone;

import java.util.List;

public interface PhoneDao {

    List<Phone> getPhone();

    void delPhone(String name);

    void addPhone(Phone phone);

    void updatePhone(Phone phone);
}
