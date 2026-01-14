package functional;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge {

    static class Person {
        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        private final String maker;
        private final String collor;
        private final Float price;

        public Car(String maker, String collor, Float price) {
            this.maker = maker;
            this.collor = collor;
            this.price = price;
        }
    }

    static class Employee {

        private final String jobTitle;
        private final Float salary;

        public Employee(String jobTitle, Float salary) {
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Person[] peopleArr = {
                new Person("Maria", 19),
                new Person("João", 30),
                new Person("Ed", 44),
                new Person("Gustavo", 22),
                new Person("Ana", 23)
        };

        Car[] carsArr = {
                new Car("Opel", "blue", 1500f),
                new Car("Opel", "white", 1250f),
                new Car("Chevrolet", "yellow", 3350f)
        };

        Employee[] employeesArr = {
                new Employee("Senior Developer", 1500f),
                new Employee("Frontend Guru", 3200f),
                new Employee("Designer", 2500f),
                new Employee("Designer", 2300f),
                new Employee("Manager", 2500f)
        };

        // 1 - get a list with only the peoples names
        List<String> names = Arrays.stream(peopleArr)
                .map(person -> person.name)
                .collect(Collectors.toList());

        System.out.println("Peoples names:");
        System.out.println(String.join(", ", names));

        // TIP: the following line does the same as above
        System.out.println(String.join(", ", names));

        // ---
        // 2 - get a list with only the blue cars
        List<Car> blueCars = Arrays.stream(carsArr)
                .filter(car -> car.collor.equals("blue"))
                .toList();
        System.out.println("Cars available with blue collor: ");
        blueCars.stream().map(car -> car.maker).forEach(System.out::println);

        // ---
        // 3 - get the sum off all employees salaries
        float sum = Arrays.stream(employeesArr)
                .map(employee -> employee.salary)
                .reduce(0f, Float::sum);

        System.out.println("Total spent with employees: " + sum);

        // ---
        // 4 - get stock per maker
        System.out.println("Showing stock...");
        Map<String, List<Car>> carsPerMaker = Arrays.stream(carsArr)
                .collect(Collectors.groupingBy(
                        c -> c.maker
                ));
        carsPerMaker.forEach((maker, cars) -> {
                    System.out.print("maker: " + maker);
                    System.out.println(" - " + cars.size() + " units");
                });


        // ---
        // 5 - get average of salaries por job title
        Map<String, Float> employeesPerJobTitle =
                Arrays.stream(employeesArr)
                        .collect(Collectors.groupingBy(employee -> employee.jobTitle))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                (entry) -> entry.getKey(),
                                (entry) -> entry.getValue()
                                                .stream()
                                                .map(employee -> employee.salary)
                                                .reduce(0f, (acc, salary) -> (acc + salary)/entry.getValue().size())
                        ));

        System.out.println("Average salary per job title: \n" + employeesPerJobTitle);

        // ---
        // 6 - get persons names for age less than 30
        String belowThirty = Arrays.stream(peopleArr)
                .filter(person -> person.age < 30)
                .map(person -> person.name)
                .collect(Collectors.joining(", "));

        System.out.println("Persons below 30: " + belowThirty);

        // ---
        // 7 - apply 5% discount for Opel cars
        System.out.println("New prices for Opel cars:");
        Arrays.stream(carsArr)
                .filter(car -> car.maker.equals("Opel"))
                .map(car -> car.price - car.price * 0.05f)
                .forEach(System.out::println);

    }

}
