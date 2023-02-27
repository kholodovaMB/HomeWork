package Modul11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Task5 {
    public static void main(String[] args) {
        Stream<String> list1 =  Arrays.asList("Ivanko", "Petrik", "Maryna", "Olga", "Tetyana").stream();
        Stream<String> list2 =  Arrays.asList("Руслана", "Миколо", "Катерина").stream();

        List<String> res = zip(list1, list2).collect(Collectors.toList());
        System.out.println(res);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> list = new ArrayList<>();

        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()){
            list.add(iterator1.next());
            list.add(iterator2.next());
        }
            return list.stream();
    }
}
