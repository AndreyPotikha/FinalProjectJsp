package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.Database;
import model.Laptop;
import model.User;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkWithJson<T>{

    private static final String PATH_JSON = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/laptop.json";


    public void setJson(List <T> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(PATH_JSON), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<T> getJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(PATH_JSON), objectMapper.getTypeFactory().
                    constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
