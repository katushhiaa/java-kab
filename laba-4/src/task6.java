/*Маючи список об’єктів Person (з полями ім’я та друзі), де friends — це список
інших об’єктів Person, напишіть функцію, яка повертає список усіх
унікальних імен друзів у верхньому регістрі (великими літерами).*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Person {
    String name;
    List<String> friends;

    public Person(String name) {
        friends = new ArrayList<>();
        this.name = name;
    }

    public void addFriend(String friend) {
        this.friends.add(friend);
    }
}

public class task6 {
    public static void main(String[] args) {
        Person petro = new Person("Petro");
        Person john = new Person("John");
        Person jane = new Person("Jane");
        Person kira = new Person("Kira");

        petro.addFriend("John");
        petro.addFriend("Jane");
        petro.addFriend("Kira");
        john.addFriend("Kira");
        jane.addFriend("John");
        kira.addFriend("Petro");

        List<Person> people = new ArrayList<>();
        people.add(petro);
        people.add(john);
        people.add(jane);
        people.add(kira);

        List<String> uniqueNames = getUniqueNames(people);
        System.out.println(uniqueNames);
    }

    private static List<String> getUniqueNames(List<Person> people) {
        return people.stream()
                .flatMap(person -> person.friends.stream()) // Перетворюємо список друзів в потік
                .map(String::toUpperCase) // Перетворюємо імена на великі літери
                .distinct() // Отримуємо унікальні імена
                .toList(); // Збираємо результат у список
    }
}

