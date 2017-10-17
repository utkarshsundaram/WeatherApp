package trex.monk.com.sunshineweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 20/6/17.
 */

public class CityModelData implements Parcelable
{
    public int id;
    public String name;
    public String country;

    public CityModelData()
    {
    }

    public int getId()

    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    protected CityModelData(Parcel in)
    {
        id = in.readInt();
        name = in.readString();
        country = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(country);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<CityModelData> CREATOR = new Creator<CityModelData>()
    {
        @Override
        public CityModelData createFromParcel(Parcel in)
        {
            return new CityModelData(in);
        }

        @Override
        public CityModelData[] newArray(int size)
        {
            return new CityModelData[size];
        }
    };
}

