package trex.monk.com.sunshineweather.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import trex.monk.com.sunshineweather.Models.ListModelData;
import trex.monk.com.sunshineweather.Models.WeatherDescriptionModelData;
import trex.monk.com.sunshineweather.R;

/**
 * Created by Acer on 6/20/2017.
 */

public class MyRecyclerAdapter  extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder>
{
    private ArrayList<ListModelData>listModelDataArrayList;
    private MyRecyclerAdapter.OnItemClickListener onItemClickListener;

    public MyRecyclerAdapter(ArrayList<ListModelData> listModelDataArrayList, OnItemClickListener onItemClickListener)
    {
        this.listModelDataArrayList = listModelDataArrayList;
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public MyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int position)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewforweatherdata, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, final int position)
    {
        ListModelData listModelData=listModelDataArrayList.get(position);

        holder.textViewDateAndTime.setText(listModelData.getDt_txt());
        String describetheweather=listModelData.getWeather().get(0).getDescription();
        if(describetheweather.equals("light rain"))
        {
            holder.ImageViewDescription.setImageResource(R.drawable.rainy);
        }
        if(describetheweather.equals("clear sky"))
        {
            holder.ImageViewDescription.setImageResource(R.drawable.suns);
        }
        else{
            holder.ImageViewDescription.setImageResource(R.drawable.cloudy);
        }

        holder.viewGroup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onItemClickListener.onClick(position);
            }
        });
        holder.viewGroup.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                onItemClickListener.onItemLongClickListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return (null != listModelDataArrayList ? listModelDataArrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewDateAndTime,textViewDescription;
        ImageView ImageViewDescription;
        public View viewGroup;
        public CustomViewHolder(View view)
        {
            super(view);
            this.textViewDateAndTime=(TextView)view.findViewById(R.id.tv_dateandtime);
            this.ImageViewDescription=(ImageView) view.findViewById(R.id.tv_description);
            this.viewGroup=(ViewGroup)view.findViewById(R.id.recyclerviewforweatherdata);
        }
    }

    public interface  OnItemClickListener
    {
        void onClick(int position);

        void onItemLongClickListener(int position);
    }
}
