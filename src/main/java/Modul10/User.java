package Modul10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public static void main(String[] args){
        ArrayList<Person> persons = new ArrayList<>();
        File file = new File("user.txt");

        if (file.exists()){
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis);
            ){
             while (scanner.hasNext()) {
                 String[] str = scanner.nextLine().split("\\s+");
                 if (!str[0].equals("name")) {
                     Person p = new Person(str[0], Integer.parseInt(str[1]));
                     persons.add(p);
                 }
             }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(persons);
        System.out.println(toJson);

        try (OutputStream fos = new FileOutputStream("user.json")){
            fos.write(toJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static class Person implements Serializable{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
