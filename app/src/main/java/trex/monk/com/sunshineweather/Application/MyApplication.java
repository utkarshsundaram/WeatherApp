package trex.monk.com.sunshineweather.Application;

import com.kelltontech.application.BaseApplication;
import com.kelltontech.volley.ext.RequestManager;

/**
 * Created by Acer on 6/20/2017.
 */

public class MyApplication extends BaseApplication
{
    @Override
    protected void initialize()
    {
        RequestManager.initializeWith(getApplicationContext(), new RequestManager.Config("data/data/DSD/pics", 5242880, 4));
    }
}
