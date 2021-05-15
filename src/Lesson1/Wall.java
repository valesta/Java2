package Lesson1;

public class Wall implements Obstacle
{
    private int size;

    public Wall(int size)
    {
        this.size = size;
    }


    @Override
    public void overcome(Competitor competitor)
    {
        competitor.jump(size);
    }
}
