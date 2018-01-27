package service.impl;

import dao.PhoneDao;
import dao.impl.PhoneDaoImpl;
import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    @Override
    public List<Phone> getPhones() {
        PhoneDao phoneDao = new PhoneDaoImpl();
        return phoneDao.getPhone();
    }

    @Override
    public void delPhones(String name) {
        PhoneDao phoneDao = new PhoneDaoImpl();
        phoneDao.delPhone(name);
    }

    @Override
    public void addPhone(Phone phone) {
        PhoneDao phoneDao = new PhoneDaoImpl();
        phoneDao.addPhone(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        PhoneDao phoneDao = new PhoneDaoImpl();
        phoneDao.updatePhone(phone);
    }
}
