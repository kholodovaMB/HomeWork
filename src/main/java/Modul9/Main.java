package Modul9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<String>(15);
        test.add("red");
        test.add("black");
        test.add("green");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
       System.out.println(test.get(1));

        MyArrayList<Integer> number = new MyArrayList<>();
        number.add(25);
        number.add(65);
        number.add(2);

        for (int i = 0; i < number.size(); i++) {
            System.out.println("number = " + number.get(i));
        }

        number.remove(0);
        for (int i = 0; i < number.size(); i++) {
            System.out.println("number = " + number.get(i));
        }

        test.clear();
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        System.out.println("size = " + test.size());

    }
}
