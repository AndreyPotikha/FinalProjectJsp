package servlet.newHard;


import model.Phone;
import service.PhoneService;
import service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newPhone")
public class NewPhoneServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String diagonal = req.getParameter("diagonal");
        String wifi = req.getParameter("wifi");
        String os = req.getParameter("os");
        String imgPath = req.getParameter("imgPath");

        Phone phone = new Phone();
        phone.setName(name);
        phone.setDiagonal(diagonal);
        phone.setWifi(wifi);
        phone.setOs(os);
        phone.setImgPath(imgPath);

        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.addPhone(phone);

        req.getRequestDispatcher("phone.jsp").forward(req, resp);
    }
}
