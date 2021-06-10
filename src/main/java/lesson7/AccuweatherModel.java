package lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.entity.Weather;
import lesson7.entity.Weather5Days;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel
{
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS = "currentconditions";
    private static final String VERSION = "v1";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String FORECASTS = "forecasts";
    private static final String DAILY = "daily";
    private static final String DAY5 = "5day";
    private static final String API_KEY = "nhnLx5wObBnbmb1lnwGoCoDNr62kzHTY";
    private static final String LANGUAGE = "ru";

    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException
    {
        if (period == Period.NOW)
        {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS)
                    .addPathSegment(VERSION)
                    .addPathSegment(getCityKey(selectedCity))
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", LANGUAGE)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();

            //TODO: сделать красивый вывод в консоль

            Response response = okHttpClient.newCall(request).execute();
            String responseBody = response.body().string();
            String date = objectMapper.readTree(responseBody).get(0).at("/LocalObservationDateTime").asText();
            String text = objectMapper.readTree(responseBody).get(0).at("/WeatherText").asText();
            int temperature = objectMapper.readTree(responseBody).get(0).at("/Temperature/Metric/Value").asInt();
            System.out.println("В городе " + selectedCity + " " + date.split("T")[0] + " " + text +
                    " и температура воздуха " + temperature + " C");

            Weather weather = new Weather(selectedCity, date.split("T")[0], text, temperature);
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            dataBaseRepository.saveWeather(weather);
        }

        // TODO*: реализовать вывод прогноза погоды на 5 дней

        if (period == Period.FIVE_DAYS)
        {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(FORECASTS)
                    .addPathSegment(VERSION)
                    .addPathSegment(DAILY)
                    .addPathSegment(DAY5)
                    .addPathSegment(getCityKey(selectedCity))
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", LANGUAGE)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String responseBody = response.body().string();
            System.out.println("В городе " + selectedCity);

            String[] arrayDate = new String[5];
            String[] arrayTextDay = new String[5];
            String[] arrayTextNight = new String[5];
            int[] arrayMinTemperature = new int[5];
            int[] arrayMaxTemperature = new int[5];

            for (int i = 0; i < 5; i++)
            {
                arrayDate[i] = objectMapper.readTree(responseBody).at("/DailyForecasts").get(i).at("/Date").asText();
                arrayTextDay[i] = objectMapper.readTree(responseBody).at("/DailyForecasts").get(i).at("/Day/IconPhrase").asText();
                arrayTextNight[i] = objectMapper.readTree(responseBody).at("/DailyForecasts").get(i).at("/Night/IconPhrase").asText();
                arrayMinTemperature[i] = objectMapper.readTree(responseBody).at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asInt();
                arrayMaxTemperature[i] = objectMapper.readTree(responseBody).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asInt();

                System.out.println(arrayDate[i].split("T")[0] + " температура " + arrayMinTemperature[i] + "-" +
                        arrayMaxTemperature[i] + " F, " + "днём " + arrayTextDay[i] + ", ночью " + arrayTextNight[i]);

                Weather5Days weather = new Weather5Days(selectedCity, arrayDate[i].split("T")[0], arrayTextDay[i],
                        arrayTextNight[i], arrayMinTemperature[i], arrayMaxTemperature[i]);
                DataBaseRepository dataBaseRepository = new DataBaseRepository();
                dataBaseRepository.saveWeather5Days(weather);
            }
        }

        if (period == Period.DATA_BASE)
        {
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            dataBaseRepository.getSavedWeather();
        }

        if (period == Period.DATA_BASE_DAYS)
        {
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            dataBaseRepository.getSavedWeatherDays();
        }
    }

    public String getCityKey(String city) throws IOException
    {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegments(LOCATIONS)
                .addPathSegments(VERSION)
                .addPathSegments(CITIES)
                .addPathSegments(AUTOCOMPLETE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();

        String cityKey = objectMapper.readTree(responseBody).get(0).at("/Key").asText();
        return cityKey;
    }
}
