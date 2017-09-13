package com.g7pro.mapapplication.Activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.g7pro.mapapplication.serverconnection.AsyncCallBack;
import com.g7pro.mapapplication.service.LocationService;
//import com.g7pro.utils.AppConfig;
//import com.g7pro.utils.CommonActions;
//import com.g7pro.utils.WebServices;


/**
 * Created by newagesmb on 12/12/16.
 */
public class BaseBTActivity extends AppCompatActivity implements ServiceConnection, View.OnClickListener, AsyncCallBack {
    public static BaseBTActivity baseBTActivity;

    AsyncCallBack asyncCallBack;
    LocalBroadcastManager mLocalBroadcastManager;
    BroadcastReceiver mBroadcastReceiver;
    private String TAG = "G7 BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseBTActivity = this;
        asyncCallBack = this;
//        mBroadcastReceiver = new BroadcastReceiver() {
//
//            @Override
//            public void onReceive(Context context, final Intent intent) {
//
//                if (intent.getAction().equals("check_push_notification")) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(BaseBTActivity.this);
//                    builder.setTitle("Test Push").setMessage("Your Push Notification is working fine.")
//                            .setCancelable(false)
//                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    AlertDialog alert = builder.create();
//                    alert.show();
//                }else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(BaseBTActivity.this);
//                    builder.setTitle("Add Stamp?").setMessage("Do you want to add stamp to the collection")
//                            .setCancelable(false)
//                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    new WebServices(BaseBTActivity.this).acceptStamp(BaseBTActivity.this, asyncCallBack, AppConfig.FUNCTION, intent.getStringExtra("id"));
//                                    dialog.dismiss();
//                                }
//                            })
//                            .setNegativeButton("Reject", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    AlertDialog alert = builder.create();
//                    alert.show();
//                }
//            }
//        };
//        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
//        IntentFilter mIntentFilter = new IntentFilter();
//        mIntentFilter.addAction("accept_stamp");
//        mIntentFilter.addAction("check_push_notification");
//        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, mIntentFilter);
    }

    @Override
    public void onClick(View view) {

    }


    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LocationService.class);
        bindService(intent, this, 0);
    }

    //you may add @override, it's optional
    protected void onStop() {
        super.onStop();
        unbindService(this);
    }

    public void onServiceConnected(ComponentName name, IBinder binder) {
        Log.e(TAG, "onServiceConnected " + name);

    }

    ;

    public void onServiceDisconnected(ComponentName name) {
        Log.e(TAG, "onServiceDisconnected " + name);
    }

    ;

    @Override
    public void onTaskCompleted(String response, int serviceCode, int taskStatus) {
//        if (serviceCode == AppConfig.FUNCTION) {
//
//            try {
//                JSONObject responseJSON = new JSONObject(response);
//                if (responseJSON.getBoolean("status")) {
//                    new CommonActions(BaseBTActivity.this).showSuccessSnackToast(toolbar, responseJSON.getString("message"));
//                } else {
//                    new CommonActions(BaseBTActivity.this).showFailureSnackToast(toolbar, responseJSON.getString("message"));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }


    @Override
    protected void onDestroy() {
        baseBTActivity = null;
//        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
        stopService(new Intent(this, LocationService.class));
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onResume() {
        super.onResume();

        baseBTActivity = this;
    }
}
