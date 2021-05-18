package Lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException
{
    public MyArraySizeException()
    {
        super("Размер массива должен быть 4х4");
    }
}
