package Lesson1;

public class Main
{
    public static void main(String[] args)
    {
        Competitor[] competitors = {
                new Cat(1,100),
                new Human(5,50),
                new Robot(10,70)
        };

        Obstacle[] obstacles = {
                new Track(3),
                new Wall(40),
                new Track(7),
                new Wall(60)
        };

        for (Obstacle obstacle:obstacles)
        {
            for (Competitor competitor:competitors)
            {
                if (!competitor.getIsActive())
                {
                    continue;
                }
                obstacle.overcome(competitor);
            }
        }
    }
}
