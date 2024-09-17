/*Створити абстрактний клас shape, що містить метод getArea(). Створіть
підкласи Circle і Rectangle, кожен з яких реалізує метод getArea().
Реалізувати метод calculateTotalArea(), із використанням Upper-bounded
wildcard, що обчислює та повертає загальну площу всіх форм у списку*/

import java.util.List;

abstract class Shape{
    public abstract double getArea();
}

class Circle extends Shape{
   private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class task6 {
    public static double calculateTotalArea(List<? extends Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        List<Shape> shapes = List.of(circle, rectangle);

        double totalArea = calculateTotalArea(shapes);
        System.out.println("Загальна площа: " + totalArea);

    }
}
