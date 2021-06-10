package lesson7;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            UserInterfaceView userInterfaceView = new UserInterfaceView();
            userInterfaceView.runInterface();
        } catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
