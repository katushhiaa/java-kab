/*Напишіть метод addToList, який приймає List<? super Integer> і додає
до нього ряд цілих чисел (наприклад, від 1 до 10). Продемонструйте
метод, додавши цілі числа до різних типів списків, наприклад
List<Integer> і List<Number>.*/

import java.util.ArrayList;
import java.util.List;

public class task7 {
        public static void addToList(List<? super Integer> list){
                for (int i = 1; i <= 10; i++) {
                        list.add(i);
                }
        }
        public static void main(String[] args) {
                List<Integer> integerList = new ArrayList<>();
                addToList(integerList);
                System.out.println("Список Integer: " + integerList);

                List<Number> numberList = new ArrayList<>();
                addToList(numberList);
                System.out.println("Список Number: " + numberList);

        }
}
