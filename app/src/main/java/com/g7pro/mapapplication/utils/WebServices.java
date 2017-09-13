package com.g7pro.mapapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.g7pro.mapapplication.serverconnection.AsyncCallBack;
import com.g7pro.mapapplication.serverconnection.HttpConnection;

import org.json.JSONObject;


/**
 * Created by gibin on 2/11/2016.
 */
public class WebServices {

    static String user_id = "";

    public static Context con;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public WebServices(Context context) {
        CommonActions commonActions = new CommonActions(context);
//        if (commonActions.isNetworkConnected()) {
            con = context;
//            prefs = con.getSharedPreferences(AppConfig.SHARED_VALUE, con.MODE_PRIVATE);
//            editor = prefs.edit();
//            user_id = prefs.getString(AppConfig.USER_ID, "");
//        } else {
//            commonActions.showFailureSnackToast(iv_splash, "Please connect to internet");
//        }
    }



//
//
//    public static void addAutograph(AsyncCallBack callbackInterface, int serviceCode, File image, String content,String to_userid) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("image", "slambook.jpg", RequestBody.create(MediaType.parse("image/jpg"), image))
//                .addFormDataPart("content", content)
//                .addFormDataPart("to_userid", to_userid)
//                .addFormDataPart("member_id", user_id)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "addAutograph", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//
//    public static void addAlbumImage(AsyncCallBack callbackInterface, int serviceCode, File image, String album_id) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("image", "slambook.jpg", RequestBody.create(MediaType.parse("image/jpg"), image))
//                .addFormDataPart("album_id", album_id)
//                .addFormDataPart("member_id", user_id)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "addAlbumImage", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//    /***
//     * api for registration
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//
//    public static void addpost(AsyncCallBack callbackInterface, int serviceCode, File image, String content) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("image", "slambook.jpg", RequestBody.create(MediaType.parse("image/jpg"), image))
//                .addFormDataPart("content", content)
//                .addFormDataPart("member_id", user_id)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "addFeeds", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//    public static void addpost(AsyncCallBack callbackInterface, int serviceCode, String content) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("content", content)
//                .addFormDataPart("member_id", user_id)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "addFeeds", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//
//    /***
//     * api for registration
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//
//    public void update_profile(AsyncCallBack callbackInterface, int serviceCode, File image, String description, String phone, String birth_day, String email, String spec, String chos) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("image", "slambook.jpg", RequestBody.create(MediaType.parse("image/jpg"), image))
//                .addFormDataPart("member_id", user_id)
//                .addFormDataPart("phone", phone)
//                .addFormDataPart("description", description)
//                .addFormDataPart("birth_day", birth_day)
//                .addFormDataPart("email", email)
//                .addFormDataPart("spec", spec)
//                .addFormDataPart("choc", chos)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "updateProfile", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//    public void update_profile(AsyncCallBack callbackInterface, int serviceCode, String description, String phone, String birth_day, String email, String spec, String chos) {
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addFormDataPart("member_id", user_id)
//                .addFormDataPart("phone", phone)
//                .addFormDataPart("description", description)
//                .addFormDataPart("birth_day", birth_day)
//                .addFormDataPart("email", email)
//                .addFormDataPart("spec", spec)
//                .addFormDataPart("choc", chos)
//                .build();
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL + "updateProfile", requestBody, null, AppConfig.POST_WITH_DATA);
//    }
//
//
//    /**
//     * api to get all users
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getAllUsers(AsyncCallBack callbackInterface, int serviceCode,String details,String version) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("request_id", user_id);
//            jsonParams.put("details", details);
//            jsonParams.put("version", version);
//            jsonMain.put("function", "getAllUsers");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api to get all users
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getAutograph(AsyncCallBack callbackInterface, int serviceCode) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getAutograph");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api to get albums
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getAlbums(AsyncCallBack callbackInterface, int serviceCode, int page) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("page", page + "");
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getAlbum");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }

    /**
     * api to save lat long
     *  @param callbackInterface
     * @param serviceCode
     * @param phone
     * @param password
     */
    public static void saveLocation(AsyncCallBack callbackInterface, int serviceCode, double phone, double password) {
        JSONObject jsonMain = new JSONObject();
        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("lattitude", phone);
            jsonParams.put("longitude", password);
            jsonMain.put("function", "saveLatLong");
            jsonMain.put("parameters", jsonParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new HttpConnection((Activity) con, callbackInterface, serviceCode,
                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
    }


 /**
     * api to get lat long
  * @param callbackInterface
  * @param serviceCode
  */
    public static void getLocation(AsyncCallBack callbackInterface, int serviceCode) {
        JSONObject jsonMain = new JSONObject();
        try {
            JSONObject jsonParams = new JSONObject();
            jsonMain.put("function", "getLatLong");
            jsonMain.put("parameters", jsonParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new HttpConnection((Activity) con, callbackInterface, serviceCode,
                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
    }

//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void feeds(AsyncCallBack callbackInterface, int serviceCode, int page) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("page", page + "");
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "feeds");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void like_dislike(AsyncCallBack callbackInterface, int serviceCode, String id, boolean like_status) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("like_status", like_status);
//            jsonParams.put("feed_id", id);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "like_dislike");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void changePassword(AsyncCallBack callbackInterface, int serviceCode, String old, String newpassword) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("old", old);
//            jsonParams.put("newPassword", newpassword);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "changePassword");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getComments(AsyncCallBack callbackInterface, int serviceCode, String id, int page) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("page", page);
//            jsonParams.put("feed_id", id);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getComments");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getBirthDays(AsyncCallBack callbackInterface, int serviceCode) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getBirthDays");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for getDetails
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getDetails(AsyncCallBack callbackInterface, int serviceCode,String member_id) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", member_id);
//            jsonMain.put("function", "getUserDetail");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//
//    /**
//     * api for getDetails
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getDetails(AsyncCallBack callbackInterface, int serviceCode) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getUserDetail");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for getAlbumDetails
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getAlbumDetails(AsyncCallBack callbackInterface, int serviceCode,String album_id) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", user_id);
//            jsonParams.put("album_id", album_id);
//            jsonMain.put("function", "getAlbumDetails");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void addComments(AsyncCallBack callbackInterface, int serviceCode, String id, String comments) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("comments", comments);
//            jsonParams.put("feed_id", id);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "addComments");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void addEvent(AsyncCallBack callbackInterface, int serviceCode, String description, String title) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("description", description);
//            jsonParams.put("title", title);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "addEvents");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void addAlbum(AsyncCallBack callbackInterface, int serviceCode, String title) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("title", title);
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "addAlbum");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }
//
//    /**
//     * api for feeds
//     *
//     * @param callbackInterface
//     * @param serviceCode
//     */
//    public static void getEvents(AsyncCallBack callbackInterface, int serviceCode) {
//        JSONObject jsonMain = new JSONObject();
//        try {
//            JSONObject jsonParams = new JSONObject();
//            jsonParams.put("member_id", user_id);
//            jsonMain.put("function", "getEvents");
//            jsonMain.put("parameters", jsonParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HttpConnection((Activity) con, callbackInterface, serviceCode,
//                AppConfig.BASE_URL, null, jsonMain, AppConfig.POST_WITH_JSON);
//    }


}