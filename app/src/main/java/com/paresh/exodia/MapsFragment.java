package com.paresh.exodia;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View maps_fragment = inflater.inflate(R.layout.fragment_map, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Campus Map");

        if (mMap == null) {
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);
        }

        RelativeLayout rl_map_type = (RelativeLayout)maps_fragment.findViewById(R.id.rl_map_type);
        ImageView iv_map_type = (ImageView)maps_fragment.findViewById(R.id.iv_map_type);
        TextView tv_map_type = (TextView)maps_fragment.findViewById(R.id.tv_map_type);


        rl_map_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_map_type.getText().toString().equals("NORMAL")){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    iv_map_type.setBackground(getResources().getDrawable(R.drawable.ic_satellite));
                    tv_map_type.setText("SATELLITE");
                }else {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    iv_map_type.setBackground(getResources().getDrawable(R.drawable.ic_map));
                    tv_map_type.setText("NORMAL");
                }

            }
        });

        return maps_fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Fragment fragment = new Home();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame,fragment);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate upadatezoom = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(upadatezoom);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        goToLocationZoom(31.773214, 76.984563, 16);
        Marker b1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772611, 76.984004))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B1")
                .snippet("Boys Hostel"));
        Marker b3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772018, 76.983950))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B3")
                .snippet("Girls Hostel"));
        Marker b4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772339, 76.984334))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B4")
                .snippet("Girls Hostel"));
        Marker b2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772383, 76.984029))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B2")
                .snippet("Boys Hostel"));
        Marker b5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771562, 76.983500))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B5")
                .snippet("Boys Hostel"));
        Marker b6 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771811, 76.983173))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B6")
                .snippet("Boys Hostel"));
        Marker b7 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771177, 76.982883))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("B7")
                .snippet("Boys Hostel"));
        Marker g3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771815, 76.983723))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("G3")
                .snippet("Boys Hostel"));
        Marker g4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771043, 76.983174))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("G4")
                .snippet("Boys Hostel"));
        Marker a1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.775356, 76.985414))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_red))
                .title("A1")
                .snippet("Academic Building"));
        Marker grnd = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773698, 76.984170))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Football")
                .snippet("Ground"));
        Marker baddy = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770549, 76.982936))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Badminton")
                .snippet("court"));
        Marker tt = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770628, 76.982970))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("TT")
                .snippet("court"));
        Marker gym = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770622, 76.982891))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Gym"));
        Marker a9 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774853, 76.983934))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_red))
                .title("A9")
                .snippet("Building"));
        Marker a5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774238, 76.985955))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_red))
                .title("A5")
                .snippet("Building"));
        Marker g2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773593, 76.985415))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_blue))
                .title("G2")
                .snippet("Boys Hostel"));
        Marker mg = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774227, 76.984969))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Cricket")
                .snippet("Ground"));
        Marker bc = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773185, 76.984682))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Basketball")
                .snippet("court"));
        Marker lt = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773114, 76.984481))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("Lawn Tennis")
                .snippet("court"));
        Marker d1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773321, 76.984957))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_green))
                .title("D1")
                .snippet("mess"));
        Marker d2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772115, 76.983557))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_green))
                .title("D2")
                .snippet("mess"));
        Marker oat = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770382, 76.983339))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_yellow))
                .title("OAT")
                .snippet("Open Air Theatre"));
        Marker afc = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772771, 76.984318))
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_pin_green))
                .title("AFC")
                .snippet("Canteen"));

    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
