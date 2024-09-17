/*Створити клас Studnt з полями, які вважаєте необхідними. Реалізувати
реєстр із використанням будь-якої імплементації інтерфейсу Mp, щоб
зберігати студентів. Додайте методи додавання, видалення та пошуку
студентів, а також відображення списку усіх студентів*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private static Map<Integer, Student> students = new HashMap<Integer, Student>();

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void addStudent(Student student) {
        students.put(student.id, student);
    }

    public static void removeStudent(Integer id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Студента з ID " + id + " видалено.");
        } else {
            System.out.println("Студента з таким ID не знайдено.");
        }
    }

    public static Student findStudents(Integer id) {
        Student student = students.get(id);
        if (students.containsKey(id)) {
            System.out.println("Знайдено студента: " + student);
        } else {
            System.out.println("Студента з таким ID не знайдено.");
        }
        return student;
    }

    public static void printStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
        public String toString () {
            return "ID: " + id + ", Name: " + name + ", Age: " + age;
        }
    }

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student(123, "Петро", 20);
        Student student2 = new Student(26, "Андрій", 51);
        Student student3 = new Student(38, "Анна", 33);
        Student student4 = new Student(436, "Оленка", 42);

        Student.addStudent(student1);
        Student.addStudent(student2);
        Student.addStudent(student3);
        Student.addStudent(student4);

        System.out.println("Всі студенти:");
        Student.printStudents();

        System.out.println("\nПошук студента по ID:");
        int findId = scanner.nextInt();
        Student.findStudents(findId);

        System.out.println("\nВведіть ID для видалення студента");
        int removeID = scanner.nextInt();
        Student.removeStudent(removeID);

        System.out.println("\nСтуденти:");
        Student.printStudents();

    }
}
