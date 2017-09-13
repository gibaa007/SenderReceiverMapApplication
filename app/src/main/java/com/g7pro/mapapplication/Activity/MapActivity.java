//package com.g7pro.mapapplication.Activity;
//
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//
//import com.g7pro.R;
//import com.g7pro.serverconnection.AsyncCallBack;
//import com.g7pro.service.GPSTracker;
//import com.g7pro.utils.CommonActions;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//
///**
// * Created by g7 on 12/09/17.
// */
//
//public class MapActivity extends BaseBTActivity implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, AsyncCallBack {
//    AsyncCallBack asyncCallBack;
//    String autoLocation = "";
//    CommonActions commonActions;
//    LatLng userSelectedLatLng;
//    String lat = "0", lng = "0";
//    GPSTracker gps;
//    private Toolbar toolbar;
//    private GoogleMap mMap;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        commonActions = new CommonActions(this);
//        setContentView(R.layout.activity_map);
//
//        gps = new GPSTracker(this);
//        init();
//    }
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//
//    /**
//     * Intializes the view with controls
//     *
//     * @param rootView
//     */
//    private void init() {
//        //Tab
//
////          mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        SupportMapFragment mapFragment = ((SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map));
//        mapFragment.getMapAsync(this);
//        mMarkersHashMap = new HashMap<Marker, ExclusivePojo>();
//
//    }
//
//
//    private void GetExclusivesTask(int position) {
//        mMap.clear();
//        gps = new GPSTracker(getActivity());
//        if (gps.canGetLocation) {
//
//            lat = String.valueOf(gps.getLatitude());
//            lng = String.valueOf(gps.getLongitude());
//        }
//
//        new WebServices(getActivity()).exclusives(getActivity(), asyncCallBack, AppConfig.EXCLUSIVES, pageNo + "", lat, lng, exclusivecatList.size() == 0 ? "0" : exclusivecatList.get(position).getExclusiveCategoryId());
//    }
//
//    private void GetExclusivesTask(int position, String lati, String longi) {
//        mMap.clear();
//        new WebServices(getActivity()).exclusives(getActivity(), asyncCallBack, AppConfig.EXCLUSIVES, pageNo + "", lati, longi, exclusivecatList.size() == 0 ? "0" : exclusivecatList.get(position).getExclusiveCategoryId());
//    }
//
//    void setAutocomplete(final AutoCompleteTextView actv) {
//        countryAdapter = new CountryListAdapter(getActivity(), AppConfig.stateList);
//        actv.setAdapter(countryAdapter);
//        actv.setThreshold(1);
//        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                GardenersFragment.country_code = view.getTag(R.id.autoText).toString();
//            }
//        });
//    }
//
//    @Override
//    public void onTaskCompleted(String response, int serviceCode, int taskStatus) {
//
//    }
//
//
//
////    /**
////     * Getting google place suggestions
////     *
////     * @author Gibin
////     */
////    GetPlaces extends AsyncTask<String, Void, ArrayList<SearchLocation>> {
////
////        @Override
////        // three dots is java for an array of strings
////        protected ArrayList<SearchLocation> doInBackground(String... args) {
////            ArrayList<SearchLocation> predictionsArr = new ArrayList<SearchLocation>();
////            try {
////                OkHTTPGet okHTTPGet = new OkHTTPGet();
////                String sb = okHTTPGet.run();
////
////                // turn that string into a JSON object
////                JSONObject predictions = new JSONObject(sb.toString());
////                // now get the JSON array that's inside that object
////                JSONArray ja = new JSONArray(
////                        predictions.getString("predictions"));
////                for (int i = 0; i < ja.length(); i++) {
////                    JSONObject jo = (JSONObject) ja.get(i);
////                    // add each entry to our array
////                    SearchLocation loc = new SearchLocation(jo.getString("place_id"), jo.getString("description"));
////                    predictionsArr.add(loc);
////                }
////            } catch (IOException e) {
////            } catch (JSONException e) {
////            }
////            return predictionsArr;
////
////        }
////
////        // then our post
////
////        @Override
////        protected void onPostExecute(ArrayList<SearchLocation> result) {
////            // update the adapter
////
////        }
////    }
//
//
//    /**
//     * Sets up the map with custom markers
//     */
//
//    public void plotMarkers(ArrayList<ExclusivePojo> exclusiveList) {
//        if (exclusiveList.size() > 0) {
//            mMap.clear();
//            for (ExclusivePojo feed : exclusiveList) {
//                double lat = Double.parseDouble(feed.getLat());
//                double lng = Double.parseDouble(feed.getLng());
//                LatLng STARTING_POINT = new LatLng(lat, lng);
//                // Create user marker with custom icon and other options
//                MarkerOptions markerOption = new MarkerOptions()
//                        .position(STARTING_POINT);
//                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_exclusive));
//                Marker currentMarker = mMap.addMarker(markerOption);
//                mMarkersHashMap.put(currentMarker, feed);
//
//                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
//                mMap.setOnMarkerClickListener(this);
//            }
//            double lat = Double.parseDouble(exclusiveList.get(0).getLat());
//            double lng = Double.parseDouble(exclusiveList.get(0).getLng());
//            LatLng STARTING_POINT = new LatLng(lat, lng);
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(STARTING_POINT, 7));
//
//
//        } else mMap.clear();
//    }
//
//    @Override
//    public void onCameraIdle() {
//
//    }
//
//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        ExclusivePojo exclusive = mMarkersHashMap.get(marker);
//        startActivity(new Intent(getActivity(), ExclusiveDetailActivity.class).
//                putExtra("exclusive", (Serializable) exclusive));
//        return false;
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        mMap.getUiSettings().setZoomControlsEnabled(false);
//    }
//
//
//
//    /**
//     * Custom Marker
//     *
//     * @author Gibin
//     */
//    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
//        TextView tv_feedname, tv_feedDescrption, tv_discount, tv_discountlabel;
//        ImageView iv_discount;
//
//        public MarkerInfoWindowAdapter() {
//        }
//
//        @Override
//        public View getInfoWindow(Marker marker) {
//            View view = getActivity().getLayoutInflater().inflate(
//                    R.layout.template_infowindow, null);
//            view.setLayoutParams(new RelativeLayout.LayoutParams(300, RelativeLayout.LayoutParams.WRAP_CONTENT));
//
//            ExclusivePojo exclusive = mMarkersHashMap.get(marker);
//            tv_feedname = (TextView) view
//                    .findViewById(R.id.tv_feedname);
//            tv_feedDescrption = (TextView) view.findViewById(R.id.tv_feedDescrption);
//            tv_discount = (TextView) view.findViewById(R.id.tv_discount);
//            tv_discountlabel = (TextView) view.findViewById(R.id.tv_discountlabel);
//            iv_discount = (ImageView) view.findViewById(R.id.iv_discount);
//            if (!exclusive.getOfferTitle().equals(null) && !exclusive.getOfferTitle().equals("null")) {
//                tv_feedname.setText(exclusive.getOfferTitle());
//            }
//            if (!exclusive.getOfferTitle().equals(null) && !exclusive.getOfferTitle().equals("null")) {
//                tv_feedDescrption.setText(exclusive.getOfferTitle());
//            }
//
//            if (exclusive.getOffer().equals("N") || exclusive.getOffer().equals("O")) {
//                iv_discount.setVisibility(View.VISIBLE);
//                tv_discount.setVisibility(View.GONE);
//                tv_discountlabel.setVisibility(View.GONE);
//                iv_discount.setImageResource(R.drawable.signup_signin_bg_default);
//            } else if (exclusive.getOffer().equals("P")) {
//                iv_discount.setVisibility(View.GONE);
//                tv_discount.setVisibility(View.VISIBLE);
//                tv_discountlabel.setVisibility(View.VISIBLE);
//                tv_discount.setText(exclusive.getOfferDesc() + "%");
//            }
//            return view;
//        }
//
//        @Override
//        public View getInfoContents(Marker marker) {
//            return null;
//        }
//
//    }
//}