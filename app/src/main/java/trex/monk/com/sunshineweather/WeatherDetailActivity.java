package trex.monk.com.sunshineweather;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import trex.monk.com.sunshineweather.Models.ListModelData;
import trex.monk.com.sunshineweather.Models.MainModelData;

import static trex.monk.com.sunshineweather.Utilities.Constants.PressureDetail;
import static trex.monk.com.sunshineweather.Utilities.Constants.WeatherDetail;
import static trex.monk.com.sunshineweather.Utilities.Constants.colorWhite;
import static trex.monk.com.sunshineweather.Utilities.Constants.colourlightblue;

public class WeatherDetailActivity extends AppCompatActivity
{
    TextView textViewWeatherDescription1,textViewWeatherDescription2,textViewWeatherDescription3,textViewWeatherDescription4;
    TextView textViewPressure,textViewTemperature,textViewCoordinate,textViewBack;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        textViewWeatherDescription1=(TextView)findViewById(R.id.tv_WeatherDetail1);
        textViewWeatherDescription2=(TextView)findViewById(R.id.tv_WeatherDetail2);
        textViewWeatherDescription3=(TextView)findViewById(R.id.tv_WeatherDetail3);
        textViewWeatherDescription4=(TextView)findViewById(R.id.tv_WeatherDetail4);
        textViewPressure=(TextView)findViewById(R.id.tv_forPressureData);
        textViewBack=(TextView)findViewById(R.id.tv_back);
        linearLayout=(LinearLayout)findViewById(R.id.layoutFordatadisplay);
        textViewTemperature=(TextView)findViewById(R.id.tv_ForTemperatureData);
        textViewCoordinate=(TextView)findViewById(R.id.tv_ForCoordinatedata);
        Intent intent=getIntent();
        if(intent!=null)
        {
             final ListModelData listModelData= getIntent().getParcelableExtra(WeatherDetail);
             String describetheweather=listModelData.getWeather().get(0).getDescription();
            if(describetheweather.equals("light rain"))
            {
                linearLayout.setBackgroundResource(R.drawable.rainbackground);
            }
            else if(describetheweather.equals("clear sky"))
            {
                linearLayout.setBackgroundResource(R.drawable.hotsunny);
            }
            else
            {
               linearLayout.setBackgroundResource(R.drawable.weatherpattern);
            }

            textViewPressure.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    textViewTemperature.setBackgroundColor(Color.parseColor(colourlightblue));
                    textViewPressure.setBackgroundColor(Color.parseColor(colorWhite));
                    textViewCoordinate.setBackgroundColor(Color.parseColor(colourlightblue));
                    textViewWeatherDescription1.setText("pressure:"+listModelData.getMain().getPressure());
                    textViewWeatherDescription2.setText("sea level:"+listModelData.getMain().getSea_level());
                    textViewWeatherDescription3.setText("groundlevel:"+listModelData.getMain().getGrnd_level());
                    textViewWeatherDescription4.setVisibility(View.INVISIBLE);

                }
            });
           textViewTemperature.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v)
               {
                   textViewPressure.setBackgroundColor(Color.parseColor(colourlightblue));
                   textViewTemperature.setBackgroundColor(Color.parseColor(colorWhite));
                   textViewCoordinate.setBackgroundColor(Color.parseColor(colourlightblue));
                   textViewWeatherDescription1.setText("temp normal :"+listModelData.getMain().getTemp());
                   textViewWeatherDescription2.setText("temp min :"+listModelData.getMain().getTemp_min());
                   textViewWeatherDescription3.setText("temp max :"+listModelData.getMain().getTemp_max());
                   textViewWeatherDescription4.setText("humidity :"+listModelData.getMain().getHumidity());
                   textViewWeatherDescription4.setVisibility(View.VISIBLE);
                   textViewWeatherDescription3.setVisibility(View.VISIBLE);
               }
           });
           textViewCoordinate.setOnClickListener(new View.OnClickListener()
           {
               @Override
               public void onClick(View v)
               {
                   textViewPressure.setBackgroundColor(Color.parseColor(colourlightblue));
                   textViewTemperature.setBackgroundColor(Color.parseColor(colourlightblue));
                   textViewCoordinate.setBackgroundColor(Color.parseColor(colorWhite));
                   textViewWeatherDescription1.setText("latitude : 28.45");
                   textViewWeatherDescription2.setText("longitude : 77.0266");
                   textViewWeatherDescription4.setVisibility(View.INVISIBLE);
                   textViewWeatherDescription3.setVisibility(View.INVISIBLE);

               }
           });
        }
        else {
            Toast.makeText(WeatherDetailActivity.this,"Intent is null",Toast.LENGTH_LONG).show();
        }
        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               Intent intent=new Intent(WeatherDetailActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}
