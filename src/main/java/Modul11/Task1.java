package Modul11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Ivanko", "Petrik", "Maryna", "Olga", "Tetyana");

        Stream<String> nameList = list.stream().filter(name -> list.indexOf(name) % 2 == 0).map(name -> String.join(". ", Integer.toString(list.indexOf(name) + 1), name));
//        List<String> newList = nameList.collect(Collectors.toList());
        String newList = nameList.collect(Collectors.joining(", "));
        System.out.println(newList);
    }
}
