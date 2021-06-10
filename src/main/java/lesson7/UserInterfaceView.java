package lesson7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView
{
    private Controller controller = new Controller();

    public void runInterface()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите опцию: 1 - получить текущую погоду, 5 - получить " +
                    "прогноз погоды на 5 дней, 0 - получить данные о текущей погоде из базы данных, 4 - получить данные" +
                    " о погоде на 5 дней из базы данных");
            String command = scanner.nextLine();

            try
            {
                controller.getWeather(command, city);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
