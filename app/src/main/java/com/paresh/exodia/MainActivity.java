package com.paresh.exodia;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.paresh.exodia.Events.EventFragment;
import com.paresh.exodia.ScheduleFragment.Schedule;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Timer timer,colorTimer;
    int page = 0;
    CustomPagerAdapter mCustomPagerAdapter;
    private boolean viewIsAtHome;
    ViewPager mViewPager;
    LinearLayout ll_home_events,ll_home_schedule,ll_home_directions,ll_home_contact_us,
            ll_home_sponsors,ll_home_app_credits;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ll_home_events = (LinearLayout)findViewById(R.id.ll_home_events);
        ll_home_schedule = (LinearLayout)findViewById(R.id.ll_home_schedule);
        ll_home_app_credits = (LinearLayout)findViewById(R.id.ll_home_app_credits);
        ll_home_directions = (LinearLayout)findViewById(R.id.ll_home_directions);
        ll_home_sponsors = (LinearLayout)findViewById(R.id.ll_home_sponsors);
        ll_home_contact_us = (LinearLayout)findViewById(R.id.ll_home_contact_us);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
        mViewPager.setAdapter(mCustomPagerAdapter);

        pageSwitcher();
        onClickMethods();
    }

    private void onClickMethods() {
        ll_home_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView(R.id.nav_contact_us);
            }
        });
        ll_home_directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView(R.id.nav_directions);
            }
        });
        ll_home_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView(R.id.nav_schedule);
            }
        });
        ll_home_app_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.nav_app_credits);
            }
        });
        ll_home_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.nav_events);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Snackbar snackbar = Snackbar
                    .make( this.findViewById(android.R.id.content).getRootView(),
                            "Press BACK again to exit", Snackbar.LENGTH_SHORT);
            snackbar.show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_directions) {
//            startActivity(new Intent(MainActivity.this,MapsActivity.class));
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.closeDrawer(GravityCompat.START);
//            return true;
            displayView(R.id.nav_directions);
        } else if (id == R.id.nav_home) {
            displayView(R.id.nav_home);
        } else if (id == R.id.nav_sponsors) {

        } else if (id == R.id.nav_contact_us) {
            displayView(R.id.nav_contact_us);
        } else if (id == R.id.nav_app_credits) {
            displayView(R.id.nav_app_credits);
        } else if (id == R.id.nav_events) {
            displayView(R.id.nav_events);
        } else if (id == R.id.nav_schedule) {
            displayView(R.id.nav_schedule);
        } else if (id == R.id.nav_about) {
            displayView(R.id.nav_about);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void pageSwitcher() {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, 3000); // delay
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 3) { // In my case the number of pages are 5
                        timer.cancel();
                        page = 0;
                        pageSwitcher();
                        // Showing a toast for just testing purpose
                    } else {
                        mViewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

    public void displayView(int viewId) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {

            case R.id.nav_contact_us:
                fragment = new ContactUs();
                viewIsAtHome = true;
                title  = "Our Team";
                break;
            case R.id.nav_home:
                fragment = new Home();
                viewIsAtHome= true;
                title = "Exodia";
                break;
            case R.id.nav_schedule:
                fragment = new Schedule();
                viewIsAtHome = true;
                title  = "Schedule";
                break;
            case R.id.nav_app_credits:
                fragment = new AppCredits();
                viewIsAtHome = true;
                title  = "App Credits";
                break;
            case R.id.nav_events:
                fragment = new EventFragment();
                viewIsAtHome = true;
                title  = "Events";
                break;
            case R.id.nav_about:
                fragment = new AboutExodia();
                viewIsAtHome = true;
                title  = "About Exodia";
                break;
            case R.id.nav_directions:
                fragment = new MapsFragment();
                viewIsAtHome = true;
                title  = "About Exodia";
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar event_name
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
