/*
Дано Map <String, List<Integer>>, де ключ: назва міста, значення: список
замірів температури за певний періодю Знайдіть місто з найвищою
середньою температурою.
* */

import java.util.*;

public class task10 {
    public static void main(String[] args) {

        Map<String, List<Integer>> temperatures = new HashMap<>();
        temperatures.put("Київ", Arrays.asList(25, 30, 28, 27));
        temperatures.put("Львів", Arrays.asList(22, 24, 26, 25));
        temperatures.put("Одеса", Arrays.asList(30, 32, 31, 29));

        String cityWithHighestAvgTemp = temperatures.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0)))
                .map(Map.Entry::getKey)
                .orElse("Немає даних");

        System.out.println("Місто з найвищою середньою температурою: " + cityWithHighestAvgTemp);
    }
}
