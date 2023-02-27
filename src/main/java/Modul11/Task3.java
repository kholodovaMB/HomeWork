package Modul11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {

        String[] list = {"1, 2, 0", "4, 5"};

       int[] res = Arrays.stream(list).map(str -> List.of(str.split(", ")))
                .flatMap(number -> number.stream())
                .mapToInt(number -> Integer.parseInt(number))
                .sorted()
               .toArray();

        System.out.println(Arrays.toString(res));
    }

}
