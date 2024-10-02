/*
*Дано Optional<Integer>. Напишіть метод, який зводить список до списку
цілих чисел, ігноруючи порожні Optionals.*/

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class task2 {

    public static List<Integer> OptionalsInt(List<Optional<Integer>> optionalList) {
        return optionalList.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());  
    }

    public static void main(String[] args) {
        List<Optional<Integer>> optionals = List.of(Optional.of(1), Optional.empty(), Optional.of(3), Optional.empty());
        List<Integer> result = OptionalsInt(optionals);
        System.out.println(result);  // Виведе: [1, 3]
    }

}
