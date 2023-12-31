package com.example.practical12;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.practical12.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView forecastTextView;
    private TextView temperatureTextView;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forecastTextView = findViewById(R.id.forecastTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        emptyTextView = findViewById(R.id.emptyTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.data.gov.sg/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);

        Call<WeatherResponse> call = weatherService.getWeatherForecast();

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    if (weatherResponse != null && weatherResponse.getItems() != null) {
                        StringBuilder weatherInfo = new StringBuilder();
                        weatherInfo.append("Region Forecasts:\n\n");

                        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
                        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                        for (WeatherItem weatherItem : weatherResponse.getItems()) {
                            for (WeatherForecast period : weatherItem.getPeriods()) {
                                ForecastRegions regions = period.getRegions();
                                Time time = period.getTime();
                                if (regions != null && time != null) {
                                    try {
                                        Date startDate = inputDateFormat.parse(time.getStart());
                                        Date endDate = inputDateFormat.parse(time.getEnd());

                                        weatherInfo.append("Time Period: ")
                                                .append("\n")
                                                .append(outputDateFormat.format(startDate))
                                                .append(" ")
                                                .append(startDate.getHours())
                                                .append(":")
                                                .append(String.format("%02d", startDate.getMinutes()))
                                                .append(" to ")
                                                .append(outputDateFormat.format(endDate))
                                                .append(" ")
                                                .append(endDate.getHours())
                                                .append(":")
                                                .append(String.format("%02d", endDate.getMinutes()))
                                                .append("\n");

                                        weatherInfo.append("\tWest: ").append(regions.getWest()).append("\n");
                                        weatherInfo.append("\tEast: ").append(regions.getEast()).append("\n");
                                        weatherInfo.append("\tCentral: ").append(regions.getCentral()).append("\n");
                                        weatherInfo.append("\tSouth: ").append(regions.getSouth()).append("\n");
                                        weatherInfo.append("\tNorth: ").append(regions.getNorth()).append("\n\n");
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        emptyTextView.setText(weatherInfo.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e("API_CALL", "Failed to fetch data: " + t.getMessage());
                t.printStackTrace();
                emptyTextView.setText("Unable to retrieve");
            }
        });
    }
}
