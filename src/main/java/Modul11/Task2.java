package Modul11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ivanko", "Petrik", "Maryna", "Olga", "Tetyana");
        String nameList = list.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.joining(", "));
        System.out.println(nameList);
    }
}
