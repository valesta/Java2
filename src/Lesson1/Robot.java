package Lesson1;

public class Robot implements Competitor
{
    private int maxRun;
    private int maxJump;
    private boolean isActive = true;

    public Robot(int maxRun, int maxJump)
    {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(int size)
    {
        if (maxRun >= size)
        {
            System.out.println("Робот успешно пробежал");
        }
        else
        {
            System.out.println("Робот не смог пробежать и выбывает из соревнований");
            isActive = false;
        }
    }

    @Override
    public void jump(int size)
    {
        if (maxJump >= size)
        {
            System.out.println("Робот успешно перепрыгнул");
        }
        else
        {
            System.out.println("Робот не смог перепрыгнуть и выбывает из соревнований");
            isActive = false;
        }
    }

    public boolean getIsActive()
    {
        return isActive;
    }
}
