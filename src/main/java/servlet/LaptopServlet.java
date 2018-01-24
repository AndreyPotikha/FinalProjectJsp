package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.LaptopDao;
import dao.impl.LaptopDaoImpl;
import model.Laptop;
import service.WorkWithJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/laptop")
public class LaptopServlet extends HttpServlet {

    private static final String PATH_JSON = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/laptop.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LaptopDao laptopDao = new LaptopDaoImpl();
        List<Laptop> allLaptops = laptopDao.getLaptops();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setLaptopJson(allLaptops);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Laptop> laptops = objectMapper.readValue(new File(PATH_JSON), objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Laptop.class));
        for (Laptop elem : laptops) {
            req.setAttribute("imgPath", elem.getImgPath());
            req.setAttribute("name", elem.getName());
            req.setAttribute("cpu", elem.getCpu());
            req.setAttribute("ram", elem.getRam());
            req.setAttribute("videoCard", elem.getVideoCard());
            req.setAttribute("hardMemory", elem.getHardMemory());
        }
    }
}
