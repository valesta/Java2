package Lesson1;

public class Cat implements Competitor
{
    private int maxRun;
    private int maxJump;
    private boolean isActive = true;

    public Cat(int maxRun, int maxJump)
    {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(int size)
    {
        if (maxRun >= size)
        {
            System.out.println("Кот успешно пробежал");
        }
        else
        {
            System.out.println("Кот не смог пробежать и выбывает из соревнований");
            isActive = false;
        }
    }

    @Override
    public void jump(int size)
    {
        if (maxJump >= size)
        {
            System.out.println("Кот успешно перепрыгнул");
        }
        else
        {
            System.out.println("Кот не смог перепрыгнуть и выбывает из соревнований");
            isActive = false;
        }
    }

    @Override
    public boolean getIsActive()
    {
        return isActive;
    }
}
