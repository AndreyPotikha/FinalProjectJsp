package service;

import com.j256.ormlite.stmt.PreparedQuery;
import model.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> findAdmin();

    void deleteAdmin();
}
