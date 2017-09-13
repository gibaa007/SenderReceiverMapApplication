package com.g7pro.mapapplication.Activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.g7pro.mapapplication.R;
import com.g7pro.mapapplication.serverconnection.AsyncCallBack;
import com.g7pro.mapapplication.utils.AppConfig;
import com.g7pro.mapapplication.utils.CommonActions;
import com.g7pro.mapapplication.utils.WebServices;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

public class MapsActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener,
        ResultCallback, LocationListener, AsyncCallBack {
    private SupportMapFragment mapFragment;
    private Marker myMarker;
    private GoogleMap googleMap;
    private int REQ_CODE_GET_LIOCATION = 2;
    private LocationManager locationManager;
    private GoogleApiClient googleApiClient;
    private boolean isCheckPermission = false;
    private double lat, lon;
    private LatLng socketLatLng;
    private Marker marker;
    private FrameLayout llMainContainer;
    private ImageView imvRecenter;
    private LatLng latLng;
    private AsyncCallBack asyncCallBack;
    private ProgressDialog pd;


    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_GET_LIOCATION) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isCheckPermission = true;
                    googleApiClient.connect();
//                    googleApiClient = initGoogleApiClient();
                    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//                    locationChnageInit(locationManager);
                    googleApiClient.connect();
                }
            }, 2000);
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        pd = new ProgressDialog(this);
        googleApiClient.connect();
        asyncCallBack = this;
        setContentView(R.layout.activity_maps);

        initGMaps();
        locationManager = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
//        locationChnageInit(locationManager);
//        String token = FirebaseInstanceId.getInstance().getToken();//for init the firbase mssagin shold not delete

        GPScheck(locationManager);
    }
//                listNearDrivers(lat+"",lon+"");


//    public GoogleApiClient initGoogleApiClient() {
//        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(activity)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
//        return googleApiClient;
//    }

//    private void listNearDrivers(String lat, String lng) {
//        RetrofitBuilder.getClient().create(ApiClientInterface.class)
//                .listNearbyDrivers(new ApiArgsBuilder(getActivity()).apiListNearbyDrivers(lat, lng))
//                .enqueue(new Callback<NearbyDriversModel>() {
//                    @Override
//                    public void onResponse(Call<NearbyDriversModel> call, Response<NearbyDriversModel> response) {
//                        NearbyDriversModel nearbyDriversModel = response.body();
//                        connectSocket();
//                        if (nearbyDriversModel.getStatus().equals("true") && nearbyDriversModel.getDrivers() != null) {
//                            for (int i = 0; i < nearbyDriversModel.getDrivers().size(); i++) {
//                                Utils.createMarker(googleMap, Double.parseDouble(nearbyDriversModel.getDrivers().get(i).getLatitude())
//                                        , Double.parseDouble(nearbyDriversModel.getDrivers().get(i).getLongitude()), R.drawable.ic_car);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<NearbyDriversModel> call, Throwable t) {
//                        Toast.makeText(this, "Cant find nearby divers...", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2) {
            if (requestCode == REQ_CODE_GET_LIOCATION) {
//                googleApiClient = initGoogleApiClient();
                googleApiClient.connect();
            }
        } else {
            Toast.makeText(this, "Please enable permission for location access...", Toast.LENGTH_SHORT).show();
        }
    }

    private void initGMaps() {
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        pd.show();
        new WebServices(MapsActivity.this).getLocation(asyncCallBack, AppConfig.LOGIN);
    }


    //    private void locationChnageInit(LocationManager locationManager) {
//        /**
//         *  for enabling the on lication change listner
//         * */
//        Criteria criteria = new Criteria();
//        criteria.setAccuracy(Criteria.ACCURACY_FINE);
//        criteria.setPowerRequirement(Criteria.ACCURACY_FINE);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            String provider = locationManager.getBestProvider(criteria, true);
//            locationManager.requestLocationUpdates(provider, 0, 0, (android.location.LocationListener) this);
//        }
//    }

    private void GPScheck(LocationManager locationManager) {
        if (null != locationManager && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            googleApiClient.connect();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Please enable location service");
            alertDialogBuilder.setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent viewIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivityForResult(viewIntent, REQ_CODE_GET_LIOCATION);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

//    private void getCurrentLocationNew(GoogleApiClient googleApiClient, LocationRequest locationRequest) {
//        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            FusedLocationProviderApi fusedLocationProviderApi = LocationServices.FusedLocationApi;
//            fusedLocationProviderApi.requestLocationUpdates(googleApiClient, locationRequest, this);
//            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
//            // TODO: 1/23/2017 put it in a thread in case of delay in fetching current location
//            if (null != lastLocation) {
//                lat = lastLocation.getLatitude();
//                lon = lastLocation.getLongitude();
//                latLng = new LatLng(lat, lon);
//                Log.d("CurrentLocation", lat + ":" + lon);
////                Utils.zoomMapToLocation(googleMap, latLng, 16);
//                locationManager.removeUpdates(this);
//                addMArker(latLng);
//                listNearDrivers(lat + "", lon + "");
//            }
//        } else {
//            if (!isCheckPermission) {
//                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQ_CODE_GET_LIOCATION);
//            }
//        }
//    }


    @Override
    public void onTaskCompleted(String response, int serviceCode, int taskStatus) {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        if (serviceCode == AppConfig.LOGIN) {
            try {
                JSONObject responseJSON = new JSONObject(response);
                if (responseJSON.getBoolean("status")) {
//                Gson gson = new GsonBuilder().create();
                    JSONObject jsonObject = responseJSON.getJSONObject("result");
                    lat = jsonObject.getDouble("lattitude");
                    lon = jsonObject.getDouble("longitude");
                    latLng = new LatLng(lat, lon);
                    zoomMapToLocation(googleMap, latLng, 16);
                    addMArker(latLng);
                } else
                    new CommonActions(this).customAlertDialog(responseJSON.getString("message"), MapsActivity.this);
            } catch (Exception e) {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
//            }
            }
        }
    }

    private void addMArker(LatLng latLng) {
        Bitmap biy = drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.abc));
        myMarker = googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .flat(true)
                .icon(BitmapDescriptorFactory.fromBitmap(biy)));
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
//        getCurrentLocationNew(googleApiClient, locationRequest);
//        lat = 10.0064;
//        lon = 76.3621;


    }

    private void zoomMapToLocation(GoogleMap map, LatLng latLng, int zoomLevel) {
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onResult(@NonNull Result result) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (googleApiClient.isConnected() && myMarker != null) {
            myMarker.setAnchor(0.5f, 0.5f);
            double lat = location.getLatitude(), longti = location.getLongitude();
            myMarker.setPosition(new LatLng(lat, longti));
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        mapProperties(googleMap);

    }

    private void mapProperties(GoogleMap googleMap) {
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);

    }

//    private void connectSocket() {
//        HopinApplication app = (HopinApplication) activity.getApplication();
//        mSocket = app.getSocket();
//        mSocket.on(Socket.EVENT_CONNECT, onConnect);
//        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
//        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
//        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
//        mSocket.on("receive location", onNewMessage);
//        mSocket.connect();
//    }

    /**
     * This funstion move the mearker forward
     *
     * @param googleMap
     * @param marker     marker to move
     * @param toPosition coordnate to move the marker
     * @param hideMarker incase of need to hide the mrker
     */


//    public void moveMarkerWithAnimation(GoogleMap googleMap, final Marker marker, final LatLng toPosition, final boolean hideMarker) {
//        nextTurnMarkerWithAnimation(marker.getPosition(), toPosition, marker);
//        if (marker != null && toPosition != null) {
//            final Handler handler = new Handler();
//            final long start = SystemClock.uptimeMillis();
//            Projection projection = googleMap.getProjection();
//            Point startPoint = projection.toScreenLocation(marker.getPosition());
//            final LatLng startLatLng = projection.fromScreenLocation(startPoint);
//            final long duration = 5 * 1000;
//            final Interpolator interpolator = new LinearInterpolator();
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    long elapsed = SystemClock.uptimeMillis() - start;
//                    float t = interpolator.getInterpolation((float) elapsed / duration);
//                    double lng = t * toPosition.longitude + (1 - t) * startLatLng.longitude;
//                    double lat = t * toPosition.latitude + (1 - t) * startLatLng.latitude;
//                    marker.setPosition(new LatLng(lat, lng));
//                    if (t < 1.0) {
//                        // Post again 16ms later.
//                        handler.postDelayed(this, 2);
//                    } else {
//                        if (hideMarker) {
//                            marker.setVisible(false);
//                        } else {
//                            marker.setVisible(true);
//                        }
//                    }
//                }
//            });
//        }
//    }

    /**
     * to rotate the marker to the movin direction
     *
     * @param crtnLoca currenrt location of the maker
     * @param toLoac   location to move the marker
     * @param marker   marker object to move
     */
    private void nextTurnMarkerWithAnimation(LatLng crtnLoca, LatLng toLoac, Marker marker) {
        Location crntLocation = new Location("");
        crntLocation.setLatitude(crtnLoca.latitude);
        crntLocation.setLongitude(crtnLoca.longitude);
        Location toLocation = new Location("");
        toLocation.setLatitude(toLoac.latitude);
        toLocation.setLongitude(toLoac.longitude);
        float endAngle = crntLocation.bearingTo(toLocation);
        marker.setRotation(endAngle);
    }

    /**
     * Updating the camera to the bearing lcoation
     */
//    public void updateCameraBearing(GoogleMap googleMap, float bearing) {
//        if (googleMap == null) return;
//        CameraPosition camPos = CameraPosition
//                .builder(googleMap.getCameraPosition()) // current Camera
//                .bearing(bearing)
//                .build();
//        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
//    }
}
