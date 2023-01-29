package Modul8;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle();
        new NameShape(circle);
        Shape quad = new Quad();
        new NameShape(quad);
        Shape rhombus = new Rhombus();
        new NameShape(rhombus);
        Shape trapezoid = new Trapezoid();
        new NameShape(trapezoid);
        Shape triangle = new Triangle();
        new NameShape(triangle);
    }
}
