package Modul9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // test MyArrayList
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
        System.out.println("---------------------------------");
        number.remove(0);
        for (int i = 0; i < number.size(); i++) {
            System.out.println("number = " + number.get(i));
        }
        System.out.println("---------------------------------");
        test.clear();
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        System.out.println("size = " + test.size());
        System.out.println("---------------------------------");
        // test MyLinkedList
        MyLinkedList<String> testMyLinked = new MyLinkedList<>();
        testMyLinked.add("Spring");
        testMyLinked.add("Summer");
        testMyLinked.add("Winter");
        for (int i = 0; i < testMyLinked.size(); i++) {
            System.out.println("season = " + testMyLinked.get(i));
        }
        System.out.println("---------------------------------");
        testMyLinked.remove(1);
        for (int i = 0; i < testMyLinked.size(); i++) {
            System.out.println("season = " + testMyLinked.get(i));
        }
        System.out.println("---------------------------------");
        testMyLinked.clear();
        System.out.println("testMyLinked.size = " + testMyLinked.size);

        System.out.println("---------------------------------");
        // test MyQueue
        MyQueue<String> testQueue = new MyQueue<String>();
        testQueue.add("Apple");
        System.out.println("testQueue = " + testQueue.peek());
        testQueue.add("Tomato");
        System.out.println("size Queue = " + testQueue.size());
        System.out.println("testQueue = " + testQueue.peek());
        System.out.println("testQueue = " + testQueue.poll());
        System.out.println("testQueue = " + testQueue.peek());
        System.out.println("size Queue = " + testQueue.size());
        testQueue.clear();
        System.out.println("size Queue = " + testQueue.size());
        System.out.println("---------------------------------");

        // Test MyStack
        MyStack<String> testStack = new MyStack<>();
        testStack.push("First");
        testStack.push("Second");
        System.out.println("testStack.peek() = " + testStack.peek());
        testStack.push("Theard");
     System.out.println("testStack.size() = " + testStack.size());
     System.out.println("---------------------------------");
        System.out.println("testStack.peek() = " + testStack.peek());
        System.out.println("testStack.pop() = " + testStack.pop());
        System.out.println("testStack.peek() = " + testStack.peek());
     System.out.println("testStack.size() = " + testStack.size());
     testStack.remove(2);
        System.out.println("testStack.peek() = " + testStack.peek());

        System.out.println("---------------------------------");
        MyHashMap<Integer, String> testHashMap = new MyHashMap<>();
        testHashMap.put(1, "Ukraine");
        testHashMap.put(2, "USA");
        testHashMap.put(3, "UK");
        testHashMap.put(4, "France");
        testHashMap.put(5, "China");

        for (int i = 1; i <= testHashMap.size(); i++) {
            System.out.println("testHashMap: " + i + " = " + testHashMap.get(i));
        }
        System.out.println("---------------------------------");
        testHashMap.remove(5);
        System.out.println("testHashMap.size() = " + testHashMap.size());
        System.out.println("---------------------------------");
        for (int i = 1; i <= testHashMap.size(); i++) {
            System.out.println("testHashMap: " + i + " = " + testHashMap.get(i));
        }
        testHashMap.clear();
        System.out.println("testHashMap.size() = " + testHashMap.size());

    }
}
