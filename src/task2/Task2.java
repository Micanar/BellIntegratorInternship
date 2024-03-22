package task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Map<String, String>> employees = new ArrayList<>();

        Map<String, String> employee1 = new HashMap<>();
        employee1.put("Имя", "Кирилл");
        employee1.put("Возраст", "26");
        employee1.put("Должность", "Middle java dev");
        employee1.put("Зарплата", "150000руб");

        Map<String, String> employee2 = new HashMap<>();
        employee2.put("Имя", "Виталий");
        employee2.put("Возраст", "28");
        employee2.put("Должность", "Senior java automation QA");
        employee2.put("Зарплата", "2000$");

        Map<String, String> employee3 = new HashMap<>();
        employee3.put("Имя", "Александр");
        employee3.put("Возраст", "31");
        employee3.put("Должность", "junior functional tester");
        employee3.put("Зарплата", "50000руб");

        Map<String, String> employee4 = new HashMap<>();
        employee4.put("Имя", "Дементий");
        employee4.put("Возраст", "35");
        employee4.put("Должность", "dev-ops");
        employee4.put("Зарплата", "1500$");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        //Вывод сотрудников младше 30 лет
        System.out.println("Сотрудники младше 30 лет:");
        employees.stream()
                .filter(employee -> Integer.parseInt(employee.get("Возраст")) < 30)
                .map(employee -> employee.get("Имя"))
                .forEach(System.out::println);

        // Вывод сотрудников получающих зп в рублях
        System.out.println("\nСотрудники получающие зп в рублях:");
        employees.stream()
                .filter(employee -> employee.get("Зарплата").endsWith("руб"))
                .map(employee -> employee.get("Имя"))
                .forEach(System.out::println);

        // Вывод средний возраст  сотрудников
        System.out.println("\nСредний возраст сотрудников:");
        OptionalDouble averageAge = employees.stream()
                .mapToInt(employee -> Integer.parseInt(employee.get("Возраст")))
                .average();
        if (averageAge.isPresent()) {
            System.out.println(averageAge.getAsDouble());
        }
    }
}
