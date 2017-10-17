package trex.monk.com.sunshineweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Acer on 6/20/2017.
 */

public class WeatherDescriptionModelData implements Parcelable
{
    public int id;
    public String main;
    public String description;

    public WeatherDescriptionModelData(int id, String main, String description)
    {
        this.id = id;
        this.main = main;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    protected WeatherDescriptionModelData(Parcel in) {
        id = in.readInt();
        main = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(main);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherDescriptionModelData> CREATOR = new Creator<WeatherDescriptionModelData>() {
        @Override
        public WeatherDescriptionModelData createFromParcel(Parcel in) {
            return new WeatherDescriptionModelData(in);
        }

        @Override
        public WeatherDescriptionModelData[] newArray(int size) {
            return new WeatherDescriptionModelData[size];
        }
    };
}
