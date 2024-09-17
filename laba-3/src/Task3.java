/*Завдання: реалізувати загальний клас під назвою Box<T> для
представлення ящика, який може містити об’єкти різних типів.
Включіть методи поміщення предметів у коробку та вилучення
предметів із коробки. Перевірте свій клас із різними типами даних.*/

class Box<T>{
    private T data;

    public void put(T data){
        this.data = data;
        System.out.println("Елемент додано: " + data);
    }
    public T get(){
        return this.data;
    }
}


public class Task3 {
    public static void main(String[] args) {

        Box<Integer> integerBox = new Box<>();
        integerBox.put(123);
        System.out.println("Елементи в боксі чисел: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.put("Hello, World!");
        System.out.println("Елементи в боксі речень: " + stringBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.put(99.99);
        System.out.println("Елементи в боксі чисел з плаваючою точкою: " + doubleBox.get());
    }
}
