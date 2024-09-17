/*
Завдання: написати загальний метод під назвою findMax-, який приймає
масив загальних елементів і знаходить максимальний елемент.
Перевірте метод із масивами різних типів, такими як Integer, Double,
Character та String.
*/


public class task4 {


        public static <T extends Comparable<T>> T findMax(T[] array){
            T max = array[0];
            for (T element : array) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
            return max;
    }

    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{1,2,3,4,56,6,7,8,9,10};
        System.out.println("Максимальне число: "+findMax(intArray));

        String[] stringArray = new String[]{"Hello","World","And","Java"};
        System.out.println("Максимальна строка: "+findMax(stringArray));

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("Максимальне число з плаваючою точкою: " + findMax(doubleArray));

        Character[] charArray = {'a','b','l','d','e','f'};
        System.out.println("Максимальний character: "+findMax(charArray));
    }
}
