package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import model.Admin;
import service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public void saveAdmin(Admin admin) {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.saveAdmin(admin);
    }

    @Override
    public List<Admin> findAdmin() {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.findAdmin();
    }

    @Override
    public void deleteAdmin() {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.deleteAdmin();
    }
}
