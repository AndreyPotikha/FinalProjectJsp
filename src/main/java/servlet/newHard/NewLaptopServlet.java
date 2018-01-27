package servlet.newHard;

import model.Laptop;
import service.LaptopService;
import service.UserService;
import service.impl.LaptopServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newLaptop")
public class NewLaptopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String cpu = req.getParameter("cpu");
        String ram = req.getParameter("ram");
        String videoCard = req.getParameter("videoCard");
        String hardMemory = req.getParameter("hardMemory");
        String imgPath = req.getParameter("imgPath");

        Laptop laptop = new Laptop();
        laptop.setName(name);
        laptop.setCpu(cpu);
        laptop.setRam(ram);
        laptop.setVideoCard(videoCard);
        laptop.setHardMemory(hardMemory);
        laptop.setImgPath(imgPath);

        LaptopService laptopService = new LaptopServiceImpl();
        laptopService.addLaptops(laptop);

        req.getRequestDispatcher("laptop.jsp").forward(req, resp);
    }
}
