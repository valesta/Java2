package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", Arrays.asList(new Course("Химия"), new Course("Биология"),
                new Course("Математика"))));
        students.add(new Student("Петров", Arrays.asList(new Course("Химия"), new Course("Биология"),
                new Course("История"), new Course("Английский"))));
        students.add(new Student("Сидоров", Arrays.asList(new Course("Химия"), new Course("Спорт"))));
        students.add(new Student("Орлов", Arrays.asList(new Course("Химия"), new Course("Биология"),
                new Course("Математика"), new Course("Спорт"), new Course("Английский"))));

        System.out.println("Список уникальных курсов: " + students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));

        System.out.println("Список трёх самых любознательных студентов: " + students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("Английский");
        System.out.println("Список студентов, посещающих курс " + course + ": " + students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
