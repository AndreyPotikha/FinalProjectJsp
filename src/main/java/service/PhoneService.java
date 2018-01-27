package service;

import model.Phone;

import java.util.List;

public interface PhoneService {

    List<Phone> getPhones();

    void delPhones(String name);

    void addPhone(Phone phone);

    void updatePhone(Phone phone);
}
