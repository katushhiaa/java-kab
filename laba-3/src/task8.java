/*
Створити ієрархію класів:
Абстрактний клас Animal із методом makeSound().
Створити дочірні класи Dog і Cat, кожен з яких реалізує метод MakeSound().
Дочірній клас Labrador:
Додайте клас Labrador, який є дочірнім для Dog. Переконайтеся, що
метод addAnimals() може додавати екземпляри Labrador до списку.
Клас AnimalShelter:
Реалізуйте клас AnimalShelter, який містить два списки: один для собак
і один для інших тварин.
Створити методи для додавання та друкування тварин за допомогою
визначених раніше методів addAnimals() і printAnimalSounds().
Метод addAnimals():
Створити метод addAnimals(), який додає об’єкти класу Dog та його
підкласів до списку тварин.
Метод printAnimalSounds():
Створити метод printAnimalSounds(), який виконує ітерацію по списку
та викликає метод makeSound() для кожної тварини.
Демонстрація функціональністі:
Створити об’єкти Dog, Cat і Labrador.
Використовуйте метод addAnimals(), щоб додати ці об’єкти до
відповідних списків у animalShelter.
Використовуйте метод    printAnimalSounds щоб вивести на екран звуки
всіх тварин у притулку.*/


import java.util.ArrayList;
import java.util.List;

abstract class Animal{
    public abstract void makeSound();
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Dog: Woof!");
    }
}

class Cat extends Animal{
    public void makeSound(){
        System.out.println("Cat: Meow!");
    }
}

class Labrador extends Dog{
    public void makeSound(){
        System.out.println("Labrador: Woof! (but softer)");
    }
}

class AnimalShelter{
    private List<Dog> DogList = new ArrayList<>();
    private List<Animal> otherAnimalsList = new ArrayList<>();

    public void addAnimals(Dog dog){
        DogList.add(dog);
    }

    public void addAnimals(Animal animal){
        if (!(animal instanceof Dog)) {
            otherAnimalsList.add(animal);
        }
    }

    public void printAnimalsSounds(){
        System.out.println("Dog sounds");
        for (Dog dog : DogList) {
            dog.makeSound();
        }

        System.out.println("\nOther animal sounds");
        for (Animal animal : otherAnimalsList) {
            animal.makeSound();
        }
    }
}


public class task8 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Labrador labrador = new Labrador();
        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimals(dog);
        shelter.addAnimals(cat);
        shelter.addAnimals(labrador);
        shelter.printAnimalsSounds();
    }
}
