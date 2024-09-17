/*
Створити generic клас pair, який міститиме два об’єкти. Реалізувати
роботу із різними типами, наприклад Pair<Integer, String> і
Pair<String, List<Integer>>. Додати метод порівняння, двох пар.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Pair<T, U>{
    T first;
    U second;
    Pair(T first, U second){
        this.first = first;
        this.second = second;
    }

    public boolean equals(Pair<T, U> obj){
        if (this == obj) return true;
        if (obj == null) return false;
        return Objects.equals(this.first, obj.first) && Objects.equals(this.second, obj.second);
    }
     public String toString(){
        return "(" + this.first + ", " + this.second + ")";
     }
}

public class task5 {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("a", 1);
        Pair<String, Integer> pair2 = new Pair<>("b", 2);

        System.out.println("Пара1: "+pair1);
        System.out.println("Пара2: "+pair2);
        System.out.println("Чи рівні ці пари: "+pair1.equals(pair2));

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3);
        Pair<String, List<Integer>> pair3 = new Pair<>("ListPair", list1);
        Pair<String, List<Integer>> pair4 = new Pair<>("ListPair", list2);

        System.out.println("Пара 3: " + pair3);
        System.out.println("Пара 4: " + pair4);
        System.out.println("Чи пара3 і пара4 рівні: " + pair3.equals(pair4));

    }
}
