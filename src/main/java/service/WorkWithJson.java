package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Laptop;
import model.Phone;
import model.Table;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WorkWithJson<T>{

    private static final String PATH_LAPTOP = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/laptop.json";
    private static final String PATH_PHONE = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/phone.json";
    private static final String PATH_TABLE = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/table.json";


    public void setLaptopJson(List<Laptop> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(PATH_LAPTOP), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Laptop> getLaptopJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(PATH_LAPTOP), objectMapper.getTypeFactory().
                    constructCollectionType(List.class, Laptop.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

     public void setPhoneJson(List<Phone> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(PATH_PHONE), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Phone> getPhoneJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(PATH_PHONE), objectMapper.getTypeFactory().
                    constructCollectionType(List.class, Phone.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

     public void setTableJson(List<Table> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(PATH_TABLE), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Table> getTableJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(PATH_TABLE), objectMapper.getTypeFactory().
                    constructCollectionType(List.class, Table.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
