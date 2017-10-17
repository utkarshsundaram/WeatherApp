package trex.monk.com.sunshineweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.kelltontech.ui.IScreen;
import com.kelltontech.utils.ConnectivityUtils;
import com.kelltontech.volley.ext.GsonObjectRequest;
import com.kelltontech.volley.ext.RequestManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import trex.monk.com.sunshineweather.Adapters.MyRecyclerAdapter;
import trex.monk.com.sunshineweather.Models.CityModelData;
import trex.monk.com.sunshineweather.Models.JSONModelData;
import trex.monk.com.sunshineweather.Models.ListModelData;
import trex.monk.com.sunshineweather.Models.MainModelData;
import trex.monk.com.sunshineweather.Models.WeatherDescriptionModelData;

import static trex.monk.com.sunshineweather.Utilities.Constants.REQUEST_DATA;
import static trex.monk.com.sunshineweather.Utilities.Constants.WeatherDetail;

public class MainActivity extends AppCompatActivity implements IScreen, MyRecyclerAdapter.OnItemClickListener,View.OnClickListener
{
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecycleAdapters;
    ProgressDialog progressDialog;
    public ArrayList<ListModelData>arrayListListModelData;
    public ArrayList<JSONModelData>arrayListJSONModelData;
    public String cityname;
    public ArrayList<String> pressureDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, layoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        createProgressDialog();
        getData(REQUEST_DATA);
   }

    @Override
    public void updateUi(boolean status, int actionID, Object serviceResponse)
    {
           switch (actionID)
           {
               case REQUEST_DATA:
                   if (serviceResponse instanceof JSONModelData)
                   {
                     JSONModelData jsonModelData =(JSONModelData)serviceResponse;
                       arrayListListModelData=(ArrayList<ListModelData>)jsonModelData.getList();
                       cityname=jsonModelData.getCity().getName();

                       mRecycleAdapters = new MyRecyclerAdapter(arrayListListModelData,this);
                       mRecycleAdapters.notifyDataSetChanged();
                       mRecyclerView.setAdapter(mRecycleAdapters);

                   }
                   break;

               default:
           }
    }

    @Override
    public void onEvent(int eventId, Object eventData)
    {

    }

    @Override
    public void getData(int actionID)
    {

        if (!ConnectivityUtils.isNetworkEnabled(this))
        {
            return;
        }
        if(actionID==REQUEST_DATA)
        {
            try
            {
                String URL="http://api.openweathermap.org/data/2.5/forecast?id=1270260&APPID=18b9eb4340b018f7bc1b637d5909c7eb";
                RequestManager.addRequest(new GsonObjectRequest<JSONModelData>(URL, new HashMap<String, String>(), null, JSONModelData.class, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(MainActivity.this,""+error,Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected void deliverResponse(JSONModelData response)
                    {
                        progressDialog.dismiss();
                        Log.e("the data has came", "deliverResponse");
                        updateUi(true,REQUEST_DATA,response);
                    }
                });

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
    public void createProgressDialog() {
        progressDialog = new ProgressDialog(MainActivity.this, R.style.Theme_AppCompat_Dialog_Alert);
        progressDialog.setMessage(Html.fromHtml("<font color='#00000'>Loading the Weather data </font>"));
        progressDialog.show();


    }


    @Override
    public void onClick(int position)
    {
        ListModelData listModelData =arrayListListModelData.get(position);
        Intent intent= new Intent(this,WeatherDetailActivity.class);
        intent.putExtra(WeatherDetail,listModelData);
        startActivity(intent);


    }

    @Override
    public void onItemLongClickListener(int position)
    {

    }

    @Override
    public void onClick(View v)
    {

    }
}
