package Lesson1;

public class Track implements Obstacle
{
    private int size;

    public Track(int size)
    {
        this.size = size;
    }


    @Override
    public void overcome(Competitor competitor)
    {
        competitor.run(size);
    }
}
