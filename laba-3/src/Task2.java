import java.util.*;

/*Написати метод, який приймає List об’єктів і повертає колекцію (будьяку на власний розсуд), що містить тільки унікальні об’єкти.
Реалізувати інший метод, який повертає Map, підраховуючи кількість
входжень кожного об’єкту.
*/
public class Task2 {
    public static <T> Collection<T> returnCollection(List<T> list) {
        return new HashSet<>(list);
    }

    public static <T> Map<T, Integer> countAppearence(List<T> list) {
        Map<T, Integer> appearence = new HashMap<>();
        for (T element : list) {
            appearence.put(element, appearence.getOrDefault(element, 0) + 1);
        }
        return appearence;
    }

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Collection<String> uniqueItems = returnCollection(items);
        System.out.println("Унікальні елементи: " + uniqueItems);

        Map<String, Integer> itemOccurrences = countAppearence(items);
        System.out.println("Кількість входжень: " + itemOccurrences);
    }
}
