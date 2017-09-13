package com.g7pro.mapapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.g7pro.mapapplication.R;
import com.g7pro.mapapplication.serverconnection.AsyncCallBack;
import com.g7pro.mapapplication.service.GPSTracker;
import com.g7pro.mapapplication.utils.AppConfig;
import com.g7pro.mapapplication.utils.CommonActions;
import com.g7pro.mapapplication.utils.WebServices;

public class MainActivity extends BaseBTActivity implements AsyncCallBack {

    GPSTracker gpsTracker;
    private AsyncCallBack asyncCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncCallBack = this;
        gpsTracker = new GPSTracker(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sender).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gpsTracker.getLatitude() != 0.0)

                    new WebServices(MainActivity.this).saveLocation(asyncCallBack, AppConfig.LOGIN, gpsTracker.getLatitude(), gpsTracker.getLongitude());

                new CommonActions(MainActivity.this).showToast("lat :" + gpsTracker.getLatitude() + " long:" + gpsTracker.getLongitude());

            }
        });

        findViewById(R.id.receiver).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                new CommonActions(this).showToast("lat :"+gpsTracker.getLatitude()+" long:"+gpsTracker.getLongitude());
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }
                });

    }


    @Override
    protected void onResume() {


        super.onResume();
    }
}
