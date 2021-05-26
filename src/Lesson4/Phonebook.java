package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook
{
    private HashMap<String, ArrayList<String>> phonebookMap;

    public Phonebook()
    {
        this.phonebookMap = new HashMap<>();
    }

    public void add(String name, String phone)
    {
        ArrayList<String> phones = phonebookMap.get(name);

        if (phones == null)
        {
            phones = new ArrayList<>();
            phonebookMap.put(name, phones);
        }

        phones.add(phone);
    }

    public void get(String Name)
    {
        if (phonebookMap.containsKey(Name))
        {
            System.out.println(Name + ": " + phonebookMap.get(Name));
        }
    }
}

