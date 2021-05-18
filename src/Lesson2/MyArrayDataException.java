package Lesson2;

public class MyArrayDataException extends NumberFormatException
{
    public MyArrayDataException(int i, int j, String s)
    {
        super("Ячейка [" + i + "]" + "[" + j +"] " + "содержит " + s + " и не может быть преобразована в тип int");
    }
}
