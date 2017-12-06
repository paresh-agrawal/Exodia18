package com.paresh.exodia;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B1")
                .snippet("Boys Hostel"));
        Marker b3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772018, 76.983950))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B3")
                .snippet("Girls Hostel"));
        Marker b4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772339, 76.984334))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B4")
                .snippet("Girls Hostel"));
        Marker b2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.772267, 76.983918))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B2")
                .snippet("Boys Hostel"));
        Marker b5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771562, 76.983500))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B5")
                .snippet("Boys Hostel"));
        Marker b6 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771811, 76.983173))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B6")
                .snippet("Boys Hostel"));
        Marker b7 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771177, 76.982883))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("B7")
                .snippet("Boys Hostel"));
        Marker g3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771815, 76.983723))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("G3")
                .snippet("Boys Hostel"));
        Marker g4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.771043, 76.983174))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin2))
                .title("G4")
                .snippet("Boys Hostel"));
        Marker a1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.775356, 76.985414))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin4))
                .title("A1")
                .snippet("Academic Building"));
        Marker grnd = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.773698, 76.984170))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                .title("Football")
                .snippet("Ground"));
        Marker baddy = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770549, 76.982936))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                .title("Badminton")
                .snippet("court"));
        Marker tt = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770628, 76.982970))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                .title("TT")
                .snippet("court"));
        Marker gym = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.770622, 76.982891))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.droppin3))
                .title("Gym"));
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
