package com.g7pro.mapapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.g7pro.mapapplication.R;
import com.g7pro.mapapplication.serverconnection.AsyncCallBack;
import com.g7pro.mapapplication.utils.AppConfig;
import com.g7pro.mapapplication.utils.CommonActions;
import com.g7pro.mapapplication.utils.WebServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by g7 on 12/09/17.
 */

public class LoginActivity extends BaseBTActivity implements AsyncCallBack {

    CommonActions commonActions;
//    CustomProgressDialog pd;
//    private SharedPreferences prefs;
//    private SharedPreferences.Editor editor;
    private Toolbar toolbar;
    private AsyncCallBack callBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commonActions = new CommonActions(this);
        callBack = this;
//        prefs = this.getSharedPreferences(AppConfig.SHARED_VALUE,
//                Context.MODE_PRIVATE);
//        editor = prefs.edit();
//        pd=new CustomProgressDialog(this);
        setContentView(R.layout.activity_login);
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText phone = (EditText) findViewById(R.id.et_phone);
                EditText pass = (EditText) findViewById(R.id.et_password);
                phone.setError(null);
                pass.setError(null);

                String username = commonActions.getTextFrom((EditText) findViewById(R.id.et_phone));
                String password = commonActions.getTextFrom((EditText) findViewById(R.id.et_password));
                if (username.length() == 0)
                    phone.setError("Enter User Name");
                else if (password.length() == 0)
                    pass.setError("Enter Password");
                else{
//                    pd.show("Signing In");
//                    new WebServices(LoginActivity.this).login(callBack, AppConfig.LOGIN, username, password);
                    startActivity(new Intent(LoginActivity.this,MapsActivity.class));
 }
            }
        });
    }

    @Override
    public void onTaskCompleted(String response, int serviceCode, int taskStatus) {
//        if (pd != null && pd.isShowing()) {
//            pd.dismiss();
//        }        if (serviceCode == AppConfig.LOGIN) {
            try {
                JSONObject responseJSON = new JSONObject(response);
                if (responseJSON.getBoolean("status")) {
                    Gson gson = new GsonBuilder().create();
                    JSONObject jsonObject = responseJSON.getJSONObject("result");
//                    ProfilePojo profilePojo = gson.fromJson(jsonObject + "", ProfilePojo.class);
//                    saveData(profilePojo);
                    startActivity(new Intent(LoginActivity.this,MapsActivity.class));
                } else
                    new CommonActions(this).customAlertDialog(responseJSON.getString("message"), LoginActivity.this);
            } catch (Exception e)
            {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
//            }
        }
    }

//    private void saveData(ProfilePojo profilePojo) {
//        if (profilePojo.getId().equals("0")) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        } else {
//            editor.putString(AppConfig.USER_ID, profilePojo.getId());
//            editor.putString(AppConfig.USER_NAME, profilePojo.getName());
//            editor.putString(AppConfig.USER_PICTURE, profilePojo.getProfileImage());
//            editor.commit();
//            startActivity(new Intent(LoginActivity.this, SplashActivity.class));
//            finish();
//        }
//    }
}