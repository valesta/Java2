package Lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit>
{
    private ArrayList<T> fruits;

    public Box()
    {
        this.fruits = new ArrayList<>();
    }

    public double getWeight()
    {
        double weight = 0;

        for (T fruit : fruits)
        {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public boolean compare(Box<?> other)
    {
        return this.getWeight() == other.getWeight();
    }

    public void add(T fruit)
    {
        fruits.add(fruit);
    }

    public void moveAllFrom(Box<T> other)
    {
        if (this == other)
        {
            throw new MoveFromItselfException();
        }

        else
        {
            fruits.addAll(other.fruits);
            other.fruits.clear();
        }
    }
}
