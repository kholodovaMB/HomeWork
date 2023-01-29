package Modul8;

public class Shape {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public void printNameShape(){
        System.out.println("Фигура " + name);
    }
}
