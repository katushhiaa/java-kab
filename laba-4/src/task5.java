/*Маючи список цілих чисел, напишіть метод обчислення добутку усіх
непарних чисел у списку. Результат загорнути в Optical.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class task5 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> result = numberList.stream()
                .filter(num -> num % 2 != 0)
                .reduce((a, b) -> a * b);

        System.out.println(result.orElse(1));
    }

}
