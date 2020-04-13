package ru.job4j.strategy;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        Square square = new Square();
        paint.draw(square);
        Triangle triangle = new Triangle();
        paint.draw(triangle);
    }
}
