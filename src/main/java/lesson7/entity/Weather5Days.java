package lesson7.entity;

public class Weather5Days
{
    private String cityName;
    private String weatherDate;
    private String weatherTextDay;
    private String weatherTextNight;
    Integer minTemperature;
    Integer maxTemperature;

    public Weather5Days(String cityName, String weatherDate, String weatherTextDay, String weatherTextNight,
                        Integer minTemperature, Integer maxTemperature)
    {
        this.cityName = cityName;
        this.weatherDate = weatherDate;
        this.weatherTextDay = weatherTextDay;
        this.weatherTextNight = weatherTextNight;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
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

    public String getWeatherTextDay()
    {
        return weatherTextDay;
    }

    public String getWeatherTextNight()
    {
        return weatherTextNight;
    }

    public Integer getMinTemperature()
    {
        return minTemperature;
    }

    public Integer getMaxTemperature()
    {
        return maxTemperature;
    }

    public void setWeatherTextDay(String weatherTextDay)
    {
        this.weatherTextDay = weatherTextDay;
    }

    public void setWeatherTextNight(String weatherTextNight)
    {
        this.weatherTextNight = weatherTextNight;
    }

    public void setMinTemperature(Integer minTemperature)
    {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature)
    {
        this.maxTemperature = maxTemperature;
    }
}
