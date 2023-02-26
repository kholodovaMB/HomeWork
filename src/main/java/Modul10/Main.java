package Modul10;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) {

        File file = new File("file.txt");
        if (file.exists()){
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis);
            ){
                while (scanner.hasNext()){
                    String phoneNumber = scanner.nextLine();
                    if (validatePhoneNumber(phoneNumber)){
                    System.out.println(phoneNumber);
                }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        String patterns
                = "^\\(?(\\d{3})\\)?[ ]?(\\d{3})[-]?(\\d{4})|\\d{3}-?\\d{3}\\-?\\d{4}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
