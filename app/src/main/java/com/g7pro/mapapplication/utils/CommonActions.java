package com.g7pro.mapapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//import com.g7pro.PojoClass.PermissionPojo;

public class CommonActions {
    Context con;

    public CommonActions(Context con) {
        // TODO Auto-generated constructor stub
        this.con = con;

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void customAlertDialogFinish(String message, final Activity activity) {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
//        alertDialogBuilder.setMessage(message);
//
//        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface arg0, int arg1) {
//                activity.setResult(AppConfig.REFRESH_ACTIVITY, new Intent());
//                activity.finish();
//            }
//        });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.setCanceledOnTouchOutside(false);
//        alertDialog.show();
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void customAlertDialog(String message, final Context activity) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public static boolean customAlertDialogreturn(String message, final Context activity) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).show();
        return true;
    }

    public static boolean checkForAlpahbet(String str1) {
        if (!Pattern.matches(".*[a-zA-Z]+.*", str1))
            return true;
        else return false;
    }

    public static boolean isLollipop() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            return true;
        } else {
            return false;
        }
    }

    public static String timeZone() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"),
                Locale.getDefault());
        String timeZone = new SimpleDateFormat("Z").format(calendar.getTime());
        return timeZone.substring(0, 3) + ":" + timeZone.substring(3, 5);
    }

    public static int timeZoneOffsetinSeconds() {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        return tz.getOffset(System.currentTimeMillis()) / 1000;
    }

    public static String getBuildVersion(Context context) {
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            ZipFile zf = new ZipFile(ai.sourceDir);
            ZipEntry ze = zf.getEntry("classes.dex");
            long time = ze.getTime();
            String s = SimpleDateFormat.getInstance().format(new java.util.Date(time));
            zf.close();
            return s;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * To hide keyboard
     *
     * @param activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity
                    .getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }

    public int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public void checkWriteExternalPermission(Activity mActivity) {
//        // Here, thisActivity is the current activity
//        if (ContextCompat.checkSelfPermission(mActivity,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//
//                // Show an explanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//
//            } else {
//
//                // No explanation needed, we can request the permission.
//
//                ActivityCompat.requestPermissions(mActivity,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                        AppConfig.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The CALL_BACK method gets the
//                // result of the request.
//            }
//        } else {
//
//            Toast.makeText(mActivity, "Permission Granted", Toast.LENGTH_SHORT).show();
//        }
    }

    /**
     * Method to show snack message
     *
     * @param view
     * @param message
     */
    public void showSuccessSnackToast(View view, String message) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.BLACK);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.GREEN);
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(null, Typeface.BOLD);
        snackbar.show();

    }

    /**
     * Method to show snack message
     *
     * @param view
     * @param message
     */
    public void showFailureSnackToast(View view, String message) {
        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.BLACK);
            View sbView = snackbar.getView();
            sbView.setBackgroundColor(Color.RED);
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            textView.setTypeface(null, Typeface.BOLD);
            snackbar.show();
        }
    }

    public void setupUI(View view, final Activity activity) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {

            view.setOnTouchListener(new OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(activity);
                    return false;
                }

            });
        }

        // If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                setupUI(innerView, activity);
            }
        }
    }

    /**
     * Method for showing toast
     *
     * @param Message
     */
    public void showToast(String Message) {
        Toast.makeText(con, Message, Toast.LENGTH_LONG).show();
    }

    /**
     * Returns the extracted text from the edit text given
     *
     * @param editText
     * @return
     */
    public String getTextFrom(EditText editText) {
        return editText.getText().toString().trim();
    }

    /**
     * Method for checking valid email id
     *
     * @param target
     * @return
     */
    public boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                .matches();
    }

    /**
     * Returns true if Internet is available
     *
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) con
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (cm.getActiveNetworkInfo() != null);
    }


//    public String unicodeConversion(String content) {
//
//        final CharSequenceTranslator ESCAPE_JAVA =
//                new LookupTranslator(
//                        new String[][]{
//                                {"\"", "\""},
//                                {"\\", "\\\\"},
//                        }).with(
//                        new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())
//                ).with(JavaUnicodeEscaper.outsideOf(32, 0x7f));
//
//        return ESCAPE_JAVA.translate(content);
//
//    }
}
