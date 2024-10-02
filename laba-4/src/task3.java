/*Маючи список імен (String), напишіть функцію, яка повертає найдовше ім’я,
загорнуту в Optical. Якщо імен немає, поверніть порожнє необов’язкове
поле.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class task3 {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Петро", "Іван", "Олег", "Дмитро");

        Optional<String> longestName = names.stream()
                .max(Comparator.comparingInt(String::length));

        String result = longestName.orElse("Імен немає");
        System.out.println("Найдовше ім'я: " + result);
    }
}
