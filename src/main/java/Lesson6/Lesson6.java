package Lesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lesson6
{
    public static void main(String[] args)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/292195?apikey=xmgcnwH16uLS2AApucRAOFjAHEV7s64T")
                .build();

        try
        {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
