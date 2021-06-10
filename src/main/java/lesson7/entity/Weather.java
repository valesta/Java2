package lesson7.entity;

public class Weather
{
    private String cityName;
    private String weatherDate;
    private String weatherText;
    Integer degrees;

    public Weather(String cityName, String weatherDate, String weatherText, Integer degrees)
    {
        this.cityName = cityName;
        this.weatherDate = weatherDate;
        this.weatherText = weatherText;
        this.degrees = degrees;
    }

    public String getWeatherDate()
    {
        return weatherDate;
    }

    public void setWeatherDate(String weatherDate)
    {
        this.weatherDate = weatherDate;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getWeatherText()
    {
        return weatherText;
    }

    public void setWeatherText(String weatherText)
    {
        this.weatherText = weatherText;
    }

    public Integer getDegrees()
    {
        return degrees;
    }

    public void setDegrees(Integer degrees)
    {
        this.degrees = degrees;
    }

    @Override
    public String toString()
    {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", degrees=" + degrees +
                '}';
    }
}
