//  Created by Gibin  on 14/09/2015.
//  Copyright (c) 2015 NewageSmb. All rights reserved.
package com.g7pro.mapapplication.utils;


//import com.g7pro.Model.StateR;
//import com.g7pro.Model.TimeZone;
//import com.g7pro.Model.UserR;

public class AppConfig {

    //    public static final String BASE_URL = "localhost/slambook/index.php/client";
    public static final String BASE_URL = "http://g7pro.in/slambook/api/";
//    public static final String BASE_URL = "http://schoolbuzz.online/index.php/api/";
//

    //PERMISSION CONSTANTS
    public final static int MY_PERMISSIONS_REQUEST_CAMERA = 80;
    public final static int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 81;
    public final static int MY_PERMISSIONS_REQUEST_MIC = 82;
    public static final int REQUEST_CODE_GALLERY = 0x1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 0x2;
    public static final int REQUEST_CODE_CROP_IMAGE = 0x3;
    public static final int REFRESH_ACTIVITY = 0x4;
    //GCM CONSTANTS
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    //Splash
    public final static int SPLASH_TIME_OUT = 5000;

    public static String DEVICE_ID = "device_id";
    public static String LOGGED_VIA = "logged_via";


    //SHARED PREFERENCE
    public static String SHARED_VALUE = "slambook_preferences";
    // USER CREDENTIALS
    //API CONSTANTS
    public static int GET = 0;
    public static int POST_WITH_DATA = 1;//Files
    public static int POST_WITH_JSON = 2;//JSON

    public static String TEMP_PROFILE_PHOTO_FILE_NAME = "temp_profile_photo.jpg";
    //USER
    public static String USER_ID = "user_id";
    public static String USER_NAME = "user_name";
    public static String USER_EMAIL = "user_email";
    public static String USER_PICTURE = "user_picture";

    //Webservice status
    public static int FAIL = 0;
    public static int SUCCESS = 1;
    public static int FAILURE_INTERNET = 2;
    public static int SESSION_EXPIRED = 3;
    public static int FAILURE_OTHER = 4;

    //WEB SERVICE METHOD CONSTANTS
    public static int LOGIN = 100;
    public static int REGISTER = 101;
    public static int POSTS = 102;
    public static int FUNCTION = 103;
    public static int ALBUMS = 104;
    public static int FEEDS = 105;
    public static int COMMENTS = 106;
    public static int ADD_EVENTS = 107;
    public static int EVENTS = 108;
    public static int ADD_POST = 109;
    public static int ADD_COMMENTS = 110;
    public static int GET_DETAILS = 111;
    public static int UPDATE_DETAILS = 112;
    public static int CHANGE_PASSWORD = 113;

    //IMAGE CHANGE
    public static int NO_CHANGE = 0;
    public static int DEFAULT_PIC_ADDED = 1;
    public static int NEW_PIC_ADDED = 2;

}
