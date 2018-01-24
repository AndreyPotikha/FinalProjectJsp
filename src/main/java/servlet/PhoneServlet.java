package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Laptop;
import model.Phone;
import service.PhoneService;
import service.WorkWithJson;
import service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/phone")
public class PhoneServlet extends HttpServlet{

    private static final String PATH_JSON = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/phone.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneService phoneService = new PhoneServiceImpl();
        List<Phone> phones = phoneService.getPhones();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setPhoneJson(phones);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Phone> phoneList = objectMapper.readValue(new File(PATH_JSON), objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Laptop.class));
        for (Phone elem : phoneList) {
            req.setAttribute("imgPath", elem.getImgPath());
            req.setAttribute("name", elem.getName());
            req.setAttribute("cpu", elem.getDiagonal());
            req.setAttribute("ram", elem.getWifi());
            req.setAttribute("videoCard", elem.getOs());
        }
    }
}
