package com.paresh.exodia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

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
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B1")
                .snippet("Boys Hostel"));
        Marker b3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772018, 76.983950))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B3")
                .snippet("Girls Hostel"));
        Marker b4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772339, 76.984334))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B4")
                .snippet("Girls Hostel"));
        Marker b2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772383, 76.984029))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B2")
                .snippet("Boys Hostel"));
        Marker b5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771562, 76.983500))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B5")
                .snippet("Boys Hostel"));
        Marker b6 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771811, 76.983173))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B6")
                .snippet("Boys Hostel"));
        Marker b7 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771177, 76.982883))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("B7")
                .snippet("Boys Hostel"));
        Marker g3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771815, 76.983723))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("G3")
                .snippet("Boys Hostel"));
        Marker g4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771043, 76.983174))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("G4")
                .snippet("Boys Hostel"));
        Marker a1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.775356, 76.985414))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_red))
                .title("A1")
                .snippet("Academic Building"));
        Marker grnd = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773698, 76.984170))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Football")
                .snippet("Ground"));
        Marker baddy = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770549, 76.982936))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Badminton")
                .snippet("court"));
        Marker tt = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770628, 76.982970))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("TT")
                .snippet("court"));
        Marker gym = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770622, 76.982891))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Gym"));
        Marker a9 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774853, 76.983934))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_red))
                .title("A9")
                .snippet("Building"));
        Marker a5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774238, 76.985955))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_red))
                .title("A5")
                .snippet("Building"));
        Marker g2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773593, 76.985415))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_blue))
                .title("G2")
                .snippet("Boys Hostel"));
        Marker mg = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.774227, 76.984969))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Cricket")
                .snippet("Ground"));
        Marker bc = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773185, 76.984682))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Basketball")
                .snippet("court"));
        Marker lt = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773114, 76.984481))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("Lawn Tennis")
                .snippet("court"));
        Marker d1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773321, 76.984957))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_green))
                .title("D1")
                .snippet("mess"));
        Marker d2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772115, 76.983557))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_green))
                .title("D2")
                .snippet("mess"));
        Marker oat = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770382, 76.983339))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_yellow))
                .title("OAT")
                .snippet("Open Air Theatre"));
        Marker afc = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772771, 76.984318))
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_pin_green))
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map_type_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.showCampus:
                goToLocationZoom(31.773214, 76.984563, 16);
                break;
            case R.id.mapTpyeNormal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.mapTpyeSatellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTpyeTerrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.mapTpyeHybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case android.R.id.home:

                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
