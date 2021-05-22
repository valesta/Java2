package Lesson3;

public class MoveFromItselfException extends RuntimeException
{
    public MoveFromItselfException()
    {
        super("Невозможно пересыпать фрукты из ящика в самого себя");
    }
}
