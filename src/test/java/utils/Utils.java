package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
//    public static String generateRandomPassword(int len) {
////        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"
////                + "abcdefghijklmnopqrstuvwxyz" + "!@#$%&";
//
//        String chars = "abcdefghij" + "123456789";
//        Random randnumber = new Random();
//        StringBuilder sb = new StringBuilder(len);
//        for (int i = 0; i < len; i++)
//            sb.append(chars.charAt(randnumber.nextInt(chars.length())));
//        return sb.toString();
//    }
    public static String generateRandomPassword() {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "@";
        String numbers = "123456";

        String allChars = uppercaseChars + lowercaseChars + specialChars + numbers;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Add the required characters from each category
        password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));

        // Add remaining characters from the numbers category
        for (int i = 0; i < 4; i++) {
            password.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        // Shuffle the characters to create a random combination
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }

        return new String(passwordArray);
    }

    public static void scroll(WebDriver driver,int w, int h){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+w+","+h+")","");

    }
    public static void scrollPage(WebDriver driver){
        WebElement genderRadio = driver.findElement(By.xpath("//input[@type=\"radio\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)");

    }
    public static int generateRandomNumber(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

    public static JSONObject getEmpID() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject empObj = (JSONObject) empArray.get(empArray.size() - 1);
        return empObj;
    }

}
