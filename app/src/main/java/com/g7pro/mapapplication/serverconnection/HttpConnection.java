package com.g7pro.mapapplication.serverconnection;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.g7pro.mapapplication.utils.AppConfig;
import com.g7pro.mapapplication.utils.CommonActions;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

import java.io.IOException;


public class HttpConnection {
    private String url;
    private JSONObject jsonParams;
    Activity con;
    AsyncCallBack callBackInterface;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private int REQUEST_TYPE;
    private int SERVICE_CODE;
    private RequestBody requestBody;


    /**
     * Parametrised constructor to do the api call
     *
     * @param con
     * @param callbackInterface
     * @param serviceCode
     * @param url
     * @param requestBody
     * @param jsonParams
     * @param request_type      REQUEST TYPE, 0 FOR GET,1 FOR POST WITH DATA,2 POST WITH JSON
     */
    public HttpConnection(Activity con, AsyncCallBack callbackInterface, int serviceCode, String url,
                          RequestBody requestBody, JSONObject jsonParams,
                          int request_type) {
        this.con = con;
        this.callBackInterface = callbackInterface;
        this.SERVICE_CODE = serviceCode;
        this.url = url;
        this.requestBody = requestBody;
        this.jsonParams = jsonParams;
        this.REQUEST_TYPE = request_type;
        prefs = con.getSharedPreferences(AppConfig.SHARED_VALUE,
                Context.MODE_PRIVATE);
        editor = prefs.edit();
        if (new CommonActions(con).isNetworkConnected()) {
            new PostTask().execute(request_type);
        } else {
            callBackInterface.onTaskCompleted("", serviceCode, AppConfig.FAILURE_INTERNET);
        }
    }


    public class PostTask extends AsyncTask<Integer, Void, String> {
        String respons = null;

        @Override
        protected String doInBackground(Integer... params) {
            // TODO Auto-generated REQUEST_TYPE stub
            if (params[0] == AppConfig.GET) {
                //SIMPLE GET REQUEST USING URL
                OkHTTPGet getHttp = new OkHTTPGet();
                try {
                    respons = getHttp.run(url);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (params[0] == AppConfig.POST_WITH_DATA) {
                //POST_WITH_DATA_FILES
                OkHTTPPost example = new OkHTTPPost();
                try {
                    respons = example.run(url, requestBody);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (params[0] == AppConfig.POST_WITH_JSON) {
                //POST_WITH_DATA_JSON
                OkHTTPPost example = new OkHTTPPost();
                try {
                    respons = example.run(url, jsonParams.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return respons;
        }

        @Override
        protected void onPostExecute(String response) {
            // TODO Auto-generated REQUEST_TYPE stub
            super.onPostExecute(response);
            if (response != null && !response.equals("error")) {
                try {
                    Log.e("***SERVER RESPONSE***", new JSONObject(response).toString(4) + "----");
                    callBackInterface.onTaskCompleted(response, SERVICE_CODE, AppConfig.SUCCESS);
                } catch (Exception e) {
                    e.printStackTrace();
                    callBackInterface.onTaskCompleted(response, SERVICE_CODE, AppConfig.FAILURE_OTHER);
                }
            } else {
                new CommonActions(con).showToast("Server Error!!! Try Again Later");
                callBackInterface.onTaskCompleted("Error in Server Response", SERVICE_CODE, AppConfig.FAILURE_OTHER);
            }
        }
    }
}