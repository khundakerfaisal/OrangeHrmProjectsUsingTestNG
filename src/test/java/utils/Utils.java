package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Random;

public class Utils {

    public static void saveEmployees(String firstName, String lastName, String employeeId, String username, String password) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObj = new JSONObject();
        empObj.put("firstName", firstName);
        empObj.put("lastName", lastName);
        empObj.put("employeeID", employeeId);
        empObj.put("userName", username);
        empObj.put("password", password);
        empArray.add(empObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(empArray.toJSONString());
        writer.flush();
        writer.close();

    }

//        public static void main(String[] args) throws IOException, ParseException {
//        saveEmployees("jamal", "kudu","jamalKudu", generateRandomPassword(8));
//    }
    public static String generateRandomPassword(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"
                + "abcdefghijklmnopqrstuvwxyz" + "!@#$%&";
        Random randnumber = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(randnumber.nextInt(chars.length())));
        return sb.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }
    public static JSONObject getEmpID() throws IOException, ParseException {
        String fileLocation="./src/test/resources/employees.json";
        JSONParser parser=new JSONParser();
        JSONArray empArray= (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObj= (JSONObject) empArray.get(empArray.size()-1);
        return empObj;
    }

}
