package Modul9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("test first");
        test.add("test second");

        System.out.println(test);
        List<String> myTest = new MyArrayList<String>();
        myTest.add("hello");
        myTest.add("fgfhfgh");
        System.out.println("myTest - " + myTest);
        System.out.println(myTest.size());
       System.out.println(myTest.get(1));
    }
}
