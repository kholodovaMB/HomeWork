package Modul11;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long m = (long) Math.pow(2, 48);
        long a = 25214903917L;
        long c = 11;
        Stream<Long> res;
        res = iterator(a, c, m);
        List<Long> str = res.collect(Collectors.toList());
        System.out.println(str);
    }
    public static Stream<Long> iterator(long a, long c, long m){
// x[n + 1] = 1 (a x[n] + c) % m
        return  Stream.iterate(0L, seed -> (1 * (a * seed + c) % m)).limit(10)
                .peek(System.out::println);

    }
}
