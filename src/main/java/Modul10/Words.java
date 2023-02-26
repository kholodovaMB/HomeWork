package Modul10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Words {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        File file = new File("words.txt");
        if (file.exists()){
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis);
            ){
                while (scanner.hasNext()){
                    String str = scanner.nextLine();
                    String[] wordsLine = (str.split("\\s+"));
                    for (String word : wordsLine) {
                        if (words.containsKey(word)){
                            int count = words.get(word);
                            words.put(word, count + 1);
                        } else {
                            words.put(word, 1);
                        }
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return words.get(o1).compareTo(words.get(o2)) > 0 ? 1 : -1;
            }
        };

        Map<String, Integer> sort = new TreeMap<>(comparator.reversed());
        sort.putAll(words);
        for (Map.Entry entry : sort.entrySet()) {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }
}
