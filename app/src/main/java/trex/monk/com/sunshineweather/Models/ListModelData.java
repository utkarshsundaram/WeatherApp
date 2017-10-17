package trex.monk.com.sunshineweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Acer on 6/20/2017.
 */

public class ListModelData implements Parcelable
{
    public String dt;
    public String dt_txt;
    public MainModelData main;
    private ArrayList<WeatherDescriptionModelData> weather;

    public ListModelData(String dt, String dt_txt, MainModelData main, ArrayList<WeatherDescriptionModelData> weather)
    {
        this.dt = dt;
        this.dt_txt = dt_txt;
        this.main = main;
        this.weather = weather;
    }

    protected ListModelData(Parcel in) {
        dt = in.readString();
        dt_txt = in.readString();
        main = in.readParcelable(MainModelData.class.getClassLoader());
        weather = in.createTypedArrayList(WeatherDescriptionModelData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dt);
        dest.writeString(dt_txt);
        dest.writeParcelable(main, flags);
        dest.writeTypedList(weather);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListModelData> CREATOR = new Creator<ListModelData>() {
        @Override
        public ListModelData createFromParcel(Parcel in) {
            return new ListModelData(in);
        }

        @Override
        public ListModelData[] newArray(int size) {
            return new ListModelData[size];
        }
    };

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public MainModelData getMain() {
        return main;
    }

    public void setMain(MainModelData main) {
        this.main = main;
    }

    public ArrayList<WeatherDescriptionModelData> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherDescriptionModelData> weather) {
        this.weather = weather;
    }




}
