package lesson7;

import lesson7.entity.Weather;
import lesson7.entity.Weather5Days;

import java.sql.*;

public class DataBaseRepository
{
    private static final String DB_URL = "jdbc:sqlite:lesson8.db";
    String insertWeatherRequest = "insert into weather_day (city, weather_date, weather_text, temperature) values" +
            " (?, ?, ?, ?)";
    String insertWeather5DayRequest = "insert into weather_days (city, weather_date, weather_day_text, " +
            "weather_night_text, min_temperature, max_temperature) values (?,?,?,?,?,?)";

    static
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void saveWeather(Weather weather)
    {
        try (Connection connection = DriverManager.getConnection(DB_URL))
        {
            PreparedStatement preparedStatement = connection.prepareStatement(insertWeatherRequest);
            preparedStatement.setString(1, weather.getCityName());
            preparedStatement.setString(2, weather.getWeatherDate());
            preparedStatement.setString(3, weather.getWeatherText());
            preparedStatement.setInt(4, weather.getDegrees());
            preparedStatement.execute();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void saveWeather5Days(Weather5Days weather)
    {
        try (Connection connection = DriverManager.getConnection(DB_URL))
        {
            PreparedStatement preparedStatement = connection.prepareStatement(insertWeather5DayRequest);
            preparedStatement.setString(1, weather.getCityName());
            preparedStatement.setString(2, weather.getWeatherDate());
            preparedStatement.setString(3, weather.getWeatherTextDay());
            preparedStatement.setString(4, weather.getWeatherTextNight());
            preparedStatement.setInt(5, weather.getMinTemperature());
            preparedStatement.setInt(6, weather.getMaxTemperature());
            preparedStatement.execute();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    //TODO: написать метод, который достанет из базы все записи о погоде и выведет пользователю

    public void getSavedWeather()
    {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(DB_URL))
        {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather_day");
            while (resultSet.next())
            {
                System.out.print(resultSet.getString("city") + ": ");
                System.out.print(resultSet.getString("weather_date") + " ");
                System.out.print(resultSet.getString("weather_text") + " и температура воздуха ");
                System.out.println(resultSet.getInt("temperature") + " C");
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void getSavedWeatherDays()
    {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(DB_URL))
        {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather_days");
            while (resultSet.next())
            {
                System.out.print(resultSet.getString("city") + ": ");
                System.out.print(resultSet.getString("weather_date") + " днём ");
                System.out.print(resultSet.getString("weather_day_text") + ", ночью ");
                System.out.print(resultSet.getString("weather_night_text") + ", температура воздуха ");
                System.out.print(resultSet.getInt("min_temperature") + "-");
                System.out.println(resultSet.getInt("max_temperature") + " F");
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
