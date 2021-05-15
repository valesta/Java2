package Lesson1;

public class Human implements Competitor
{
    private int maxRun;
    private int maxJump;
    private boolean isActive = true;

    public Human(int maxRun, int maxJump)
    {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(int size)
    {
        if (maxRun >= size)
        {
            System.out.println("Человек успешно пробежал");
        }
        else
        {
            System.out.println("Человек не смог пробежать и выбывает из соревнований");
            isActive = false;
        }
    }

    @Override
    public void jump(int size)
    {
        if (maxJump >= size)
        {
            System.out.println("Человек успешно перепрыгнул");
        }
        else
        {
            System.out.println("Человек не смог перепрыгнуть и выбывает из соревнований");
            isActive = false;
        }
    }

    public boolean getIsActive()
    {
        return isActive;
    }
}
