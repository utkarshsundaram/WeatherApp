package trex.monk.com.sunshineweather.Models;

import java.util.ArrayList;

/**
 * Created by Acer on 6/20/2017.
 */

public class JSONModelData
{
    public  String cod;
    public  String message;
    public int cnt;
    private ArrayList<ListModelData> list;
    private CityModelData city;

    public CityModelData getCity()
    {
        return city;
    }

    public void setCity(CityModelData city)
    {
        this.city = city;
    }


    public JSONModelData(String cod, String message, int cnt, ArrayList<ListModelData> list,CityModelData city)
    {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city=city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ListModelData> getList() {
        return list;
    }

    public void setList(ArrayList<ListModelData> list) {
        this.list = list;
    }


}
