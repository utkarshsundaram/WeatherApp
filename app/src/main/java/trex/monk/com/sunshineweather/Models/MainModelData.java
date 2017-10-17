package trex.monk.com.sunshineweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Acer on 6/20/2017.
 */

public class MainModelData implements Parcelable
{
    public float temp;
    public float temp_min;
    public float temp_max;
    public float pressure;
    public float sea_level;
    public float grnd_level;
    public float humidity;
    public float temp_kf;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }


    protected MainModelData(Parcel in)
    {
        temp = in.readFloat();
        temp_min = in.readFloat();
        temp_max = in.readFloat();
        pressure = in.readFloat();
        sea_level = in.readFloat();
        grnd_level = in.readFloat();
        humidity = in.readFloat();
        temp_kf = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(temp);
        dest.writeFloat(temp_min);
        dest.writeFloat(temp_max);
        dest.writeFloat(pressure);
        dest.writeFloat(sea_level);
        dest.writeFloat(grnd_level);
        dest.writeFloat(humidity);
        dest.writeFloat(temp_kf);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainModelData> CREATOR = new Creator<MainModelData>() {
        @Override
        public MainModelData createFromParcel(Parcel in) {
            return new MainModelData(in);
        }

        @Override
        public MainModelData[] newArray(int size) {
            return new MainModelData[size];
        }
    };
}
