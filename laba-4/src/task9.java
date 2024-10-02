/*У вас є Map, де ключі є ідентифікаторами продукту, а значення є
необов’язковими для назв продуктів. Напишіть метод, який повертає список
назв продуктів у верхньому регістрі для всіх непорожніх Optionals */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class task9 {
    public static List<String> UpperCaseProductNames(Map<Integer, Optional<String>> productMap) {
        return productMap.values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Map<Integer, Optional<String>> products = new HashMap<>();
        products.put(1, Optional.of("яблуко"));
        products.put(2, Optional.empty());
        products.put(3, Optional.of("банан"));
        products.put(4, Optional.of("апельсин"));

        List<String> upperCaseNames = UpperCaseProductNames(products);
        System.out.println(upperCaseNames);
    }
}
