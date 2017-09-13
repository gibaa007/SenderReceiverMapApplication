package com.g7pro.mapapplication.Activity;//package com.g7pro.Activity;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.pm.FeatureInfo;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.app.AlertDialog;
//import android.util.Log;
//import android.widget.ImageView;
//
//import com.g7pro.PojoClass.MessagePojo;
//import com.g7pro.R;
//import com.g7pro.serverconnection.AsyncCallBack;
//import com.g7pro.service.LocationService;
//import com.g7pro.utils.AppConfig;
//import com.g7pro.utils.CommonActions;
//import com.g7pro.utils.CustomProgressDialog;
//import com.g7pro.utils.WebServices;
//import com.crashlytics.android.Crashlytics;
//import com.facebook.drawee.backends.pipeline.Fresco;
//import com.twitter.sdk.android.Twitter;
//import com.twitter.sdk.android.core.TwitterAuthConfig;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import io.fabric.sdk.android.Fabric;
//
//public class SplashActivity extends BaseBTActivity implements AsyncCallBack {
//
//    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
//    private static final String TWITTER_KEY = "jQxvI0qtzYVFy3O8oaJzzaH3N";
//    private static final String TWITTER_SECRET = "la8Ymof6pYtGxSDewoHWEnsNXOoXI03Ran2FLmFpgySNG1dqgS";
//    public static ImageView iv_eden_image;
//    public static String splash_user_id = "", splash_user_pic = "", splash_user_name = "", splash_user_type = "";
//    private static int SPLASH_TIME_OUT = 1000;
//    CommonActions commonActions;
//    AsyncCallBack asyncCallBack;
//    Intent intent = null;
//    private SharedPreferences sharedpreferences = null;
//    private SharedPreferences.Editor editor = null;
//    private CustomProgressDialog pd;
//    private boolean fromPush;
//
//    private static int getVersionFromPackageManager(Context context) {
//        PackageManager packageManager = context.getPackageManager();
//        FeatureInfo[] featureInfos = packageManager.getSystemAvailableFeatures();
//        if (featureInfos != null && featureInfos.length > 0) {
//            for (FeatureInfo featureInfo : featureInfos) {
//                // Null feature name means this feature is the open gl es version feature.
//                if (featureInfo.name == null) {
//                    if (featureInfo.reqGlEsVersion != FeatureInfo.GL_ES_VERSION_UNDEFINED) {
//                        return getMajorVersion(featureInfo.reqGlEsVersion);
//                    } else {
//                        return 1; // Lack of property means OpenGL ES version 1
//                    }
//                }
//            }
//        }
//        return 1;
//    }
//
//    /**
//     * @see FeatureInfo#getGlEsVersion()
//     */
//    private static int getMajorVersion(int glEsVersion) {
//        Log.e("eden", glEsVersion + "");
//
//        return ((glEsVersion & 0xffff0000) >> 16);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
//        Fabric.with(this, new Twitter(authConfig), new Crashlytics());
//        commonActions = new CommonActions(this);
//        asyncCallBack = this;
//        pd = new CustomProgressDialog(SplashActivity.this);
//        if (!Fresco.hasBeenInitialized())
//            Fresco.initialize(this);
//        sharedpreferences = this.getSharedPreferences(AppConfig.SHARED_VALUE,
//                Context.MODE_PRIVATE);
//
//
//        Log.e("eden11", getVersionFromPackageManager(this) + "");
//        editor = sharedpreferences.edit();
//        setContentView(R.layout.activity_splash);
//        iv_eden_image = (ImageView) findViewById(R.id.iv_eden_image);
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public SharedPreferences sharedPreferences;
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//
//            @Override
//            public void run() {
////                sharedPreferences = getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
////                SharedPreferences.Editor editor = sharedPreferences.edit();
////                boolean firstTime = sharedPreferences.getBoolean("first", true);
////                if (signedIn) {
////                    editor.putBoolean("first", false);
////                    //For commit the changes, Use either editor.commit(); or  editor.apply();.
////                    editor.commit();
////                Toast.makeText(SplashActivity.this, sharedpreferences.getString(AppConfig.USER_ID, ""), Toast.LENGTH_SHORT).show();
//                if (sharedpreferences.getString(AppConfig.USER_ID, "").equals("")) {
//                    intent = new Intent(SplashActivity.this, WelcomeActivity.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//
//                    pd.show();
//                    if (commonActions.isNetworkConnected())
//                        new WebServices(SplashActivity.this).login(SplashActivity.this, asyncCallBack, AppConfig.LOGIN, sharedpreferences.getString(AppConfig.USER_NAME, ""), sharedpreferences.getString(AppConfig.USER_PASSWORD, ""),
//                                sharedpreferences.getString(AppConfig.PROPERTY_REG_ID, ""), sharedpreferences.getString(AppConfig.USER_LAT, ""), sharedpreferences.getString(AppConfig.USER_LNG, ""));
//                    else
//                        commonActions.showFailureSnackToast(iv_eden_image, "Please connect to internet");
//
//                }
////                } else {
////
////                }
//            }
//        }, SPLASH_TIME_OUT);
//    }
//
//    @Override
//    protected void onResume() {
//        if (fromPush) {
//            fromPush = false;
//            Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(i);
//        }
//        super.onResume();
//
//    }
//
//    @Override
//    public void onTaskCompleted(String response, int serviceCode, int taskStatus) {
//        if (pd.isShowing()) {
//            pd.cancel();
//        }
//        if (serviceCode == AppConfig.LOGIN) {
//
//            startService(new Intent(this, LocationService.class));
//            try {
//                JSONObject resposnseJSON = new JSONObject(response);
//                if (resposnseJSON.getBoolean("status")) {
//                    JSONObject user_infoJSON = resposnseJSON.getJSONObject("data");
//                    editor.putString(AppConfig.USER_NAME, user_infoJSON.getString("username"));
//                    editor.putString(AppConfig.USER_ID, user_infoJSON.getString("user_id"));
//                    editor.putString(AppConfig.USER_EMAIL, user_infoJSON.getString("email"));
//                    editor.putString(AppConfig.USER_TYPE, user_infoJSON.getString("user_type"));
//                    editor.putString(AppConfig.USER_FULL_NAME, user_infoJSON.getString("full_name"));
//                    editor.putString(AppConfig.USER_COUNTRY, user_infoJSON.getString("country_name"));
//                    editor.putString(AppConfig.USER_LAT, user_infoJSON.getString("lat"));
//                    editor.putString(AppConfig.USER_LNG, user_infoJSON.getString("lng"));
//                    editor.putString(AppConfig.USER_PROFILE_PIC, user_infoJSON.getString("profile_image"));
//                    editor.putString(AppConfig.USER_COVER_PIC, user_infoJSON.getString("cover_image"));
//                    editor.commit();
//
//                    splash_user_id = sharedpreferences.getString(AppConfig.USER_ID, "");
//                    splash_user_type = sharedpreferences.getString(AppConfig.USER_TYPE, "");
//                    splash_user_pic = sharedpreferences.getString(AppConfig.USER_PROFILE_PIC, "");
//                    splash_user_name = sharedpreferences.getString(AppConfig.USER_FULL_NAME, "");
//                    final Bundle bundle = getIntent().getExtras();
//                    if (bundle != null) {
//                        if ((String) bundle.get("tag") != null) {
//                            String tag = (String) bundle.get("tag");
//                            if (tag.equals("new_message")) {
//                                if (!Fresco.hasBeenInitialized())
//                                    Fresco.initialize(this);
//                                MessagePojo messagePojo = new MessagePojo((String) bundle.get("id"), (String) bundle.get("full_name"), (String) bundle.get("profile_image"));
//                                Intent messageDetail = new Intent(SplashActivity.this, MessageDetailsActivity.class);
//                                messageDetail.putExtra("messageData", messagePojo);
//                                messageDetail.putExtra("fromPush", false);
//                                messageDetail.putExtra("blocked", false);
//                                startActivity(messageDetail);
//                            } else if (tag.equals("accept_stamp")) {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                                builder.setTitle("Add Stamp?").setMessage("Do you want to add stamp to the collection")
//                                        .setCancelable(false)
//                                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int id) {
//                                                pd.show();
//                                                new WebServices(SplashActivity.this).acceptStamp(SplashActivity.this, asyncCallBack, AppConfig.FUNCTION, (String) bundle.get("id"));
//                                            }
//                                        })
//                                        .setNegativeButton("Reject", new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int id) {
//                                                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                                startActivity(i);
//                                            }
//                                        });
//                                AlertDialog alert = builder.create();
//                                alert.show();
//                            } else {
//                                openSpecificActivity(tag, (String) bundle.get("id"));
//                            }
//
//
//                            fromPush = true;
//
//                        } else {
//                            Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(i);
//                        }
//                    } else {
//                        Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(i);
//                    }
//                } else {
//
//                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(
//                            this);
//                    builder.setMessage(resposnseJSON.getString("message"));
//                    builder.setCancelable(false)
//                            .setPositiveButton("OK",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int id) {
//                                            Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
//                                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                            startActivity(i);
//                                        }
//                                    })
//                            .show();
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        } else if (serviceCode == AppConfig.FUNCTION) {
//
//            try {
//                JSONObject responseJSON = new JSONObject(response);
//                if (responseJSON.getBoolean("status")) {
//                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//                    alertDialogBuilder.setMessage(responseJSON.getString("message"));
//                    alertDialogBuilder.setCancelable(false)
//                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                    startActivity(i);
//                                }
//                            }).show();
//                } else {
//                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//                    alertDialogBuilder.setMessage(responseJSON.getString("message"));
//                    alertDialogBuilder.setCancelable(false)
//                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                    startActivity(i);
//                                }
//                            }).show();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (serviceCode == AppConfig.FUNCTION) {
//
//            JSONObject resposnseJSON = null;
//            try {
//                resposnseJSON = new JSONObject(response);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    private void openSpecificActivity(String tag, String id) {
//
//        Intent intent = null;
//        if (tag.equals("post_comment") || tag.equals("near_communitypost")) {
//            intent = new Intent(this, PostDetailActivity.class);
//            intent.putExtra("postId", id);
//        } else if (tag.equals("friend_request") || tag.equals("near_friend")) {
//            intent = new Intent(this, ProfileViewActivity.class);
//            intent.putExtra("userId", id);
//        } else if (tag.equals("new_question") || tag.equals("question_reply")) {
//            intent = new Intent(this, QuestionDetailsActivity.class);
//            intent.putExtra("questId", id);
//            intent.putExtra("title", "Question");
//        } else if (tag.equals("near_exclusive")) {
//            intent = new Intent(this, ExclusiveDetailActivity.class);
//            intent.putExtra("exclusiveId", Integer.parseInt(id));
//        } else if (tag.equals("accept_stamp")) {
//
//        }
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//    }
//
//}
