/*Маючи список об’єктів Employee (з полями ім’я та зарплата), згрупуйте
співробітників за діапазоном зарплати (наприклад, < 3000, 3000–5000, >
5000) і для кожної групи поверніть працівника з найвищою зарплатою.
*/

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class task4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 2500),
                new Employee("Jane", 3500),
                new Employee("Mary", 4500),
                new Employee("Peter", 6000),
                new Employee("Lucy", 7000)
        );

        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> {
                            if (emp.getSalary() < 3000) {
                                return "< 3000";
                            } else if (emp.getSalary() <= 5000) {
                                return "3000-5000";
                            } else {
                                return "> 5000";
                            }
                        },
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        result.forEach((range, emp) -> System.out.println(range + ": " + emp.orElse(null)));
    }
}

