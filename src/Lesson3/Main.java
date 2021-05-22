package Lesson3;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Box<Apple> appleBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();
        Box<Apple> appleBox2 = new Box<Apple>();

        appleBox.add(new Apple(1));
        appleBox.add(new Apple(1));
        appleBox.add(new Apple(1));

        orangeBox.add(new Orange(1.5));
        orangeBox.add(new Orange(1.5));
        orangeBox.add(new Orange(1.5));

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox2.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        appleBox2.moveAllFrom(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
    }
}
