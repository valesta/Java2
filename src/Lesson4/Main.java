package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class Main
{
    public static void main(String[] args)
    {
        // Задание №1

        ArrayList<String> words = new ArrayList<>(asList("Кошка", "Собака", "Хомяк", "Попугай", "Кошка", "Корова",
                "Хомяк", "Утка", "Кошка", "Кролик", "Собака", "Рыба", "Лошадь", "Кошка", "Хомяк"));
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (String word : words)
        {
            if (wordsMap.containsKey(word))
            {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
            else
            {
                wordsMap.put(word, 1);
            }
        }

        System.out.println("Список уникальных слов: " + wordsMap.keySet());

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet())
        {
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз");
        }

        // Задание №2

        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "89999999");
        phonebook.add("Петров", "89997777");
        phonebook.add("Сидоров", "89995555");
        phonebook.add("Смирнов", "89993333");
        phonebook.add("Орлов", "89991111");
        phonebook.add("Иванов", "89998888");
        phonebook.add("Петров", "89996666");
        phonebook.add("Иванов", "89994444");

        phonebook.get("Иванов");
    }
}
