import java.util.Scanner;

abstract class Shape {
    String name;

    abstract double getArea();

    abstract double getPerimeter();
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape {
    double radius;

    Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    double side1, side2, side3;

    Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

class Square extends Rectangle {
    Square(String name, double sideLength) {
        super(name, sideLength, sideLength);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a shape (Rectangle, Circle, Triangle, Square) or type 'exit' to quit:");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            Shape shape;
            switch (choice) {
                case "Rectangle":
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    shape = new Rectangle(choice, width, height);
                    break;

                case "Circle":
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    shape = new Circle(choice, radius);
                    break;

                case "Triangle":
                    System.out.print("Enter side1: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Enter side2: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter side3: ");
                    double side3 = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    shape = new Triangle(choice, side1, side2, side3);
                    break;

                case "Square":
                    System.out.print("Enter side length: ");
                    double sideLength = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    shape = new Square(choice, sideLength);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid shape.");
                    continue;
            }

            System.out.println("Shape: " + shape.name);
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
