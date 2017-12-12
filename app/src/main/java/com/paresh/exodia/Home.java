package com.paresh.exodia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.paresh.exodia.ScheduleFragment.Schedule;

import java.util.Timer;
import java.util.TimerTask;

import static com.google.android.gms.internal.zzagr.runOnUiThread;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    Timer timer,colorTimer;
    int page = 0;
    CustomPagerAdapter mCustomPagerAdapter;
    private boolean viewIsAtHome;
    ViewPager mViewPager;
    LinearLayout ll_home_events,ll_home_schedule,ll_home_directions,ll_home_contact_us,
            ll_home_sponsors,ll_home_app_credits;

    public Home() {
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
        View home = inflater.inflate(R.layout.fragment_home, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Exodia");

        ll_home_events = (LinearLayout)home.findViewById(R.id.ll_home_events);
        ll_home_schedule = (LinearLayout)home.findViewById(R.id.ll_home_schedule);
        ll_home_app_credits = (LinearLayout)home.findViewById(R.id.ll_home_app_credits);
        ll_home_directions = (LinearLayout)home.findViewById(R.id.ll_home_directions);
        ll_home_sponsors = (LinearLayout)home.findViewById(R.id.ll_home_sponsors);
        ll_home_contact_us = (LinearLayout)home.findViewById(R.id.ll_home_contact_us);

        mCustomPagerAdapter = new CustomPagerAdapter(getActivity());
        mViewPager = (ViewPager) home.findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) home.findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
        mViewPager.setAdapter(mCustomPagerAdapter);

        pageSwitcher();
        onClickMethods();

        return home;
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
                startActivity(new Intent(getActivity(),MapsActivity.class));
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
                title  = "App Credits";
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
