package com.paresh.exodia;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Schedule extends Fragment {

    private TextView mTextMessage;

    private ScrollView sv_day1,sv_day2,sv_day3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_day1:
                    sv_day1.setVisibility(View.VISIBLE);
                    sv_day2.setVisibility(View.INVISIBLE);
                    sv_day3.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_day2:
                    sv_day1.setVisibility(View.INVISIBLE);
                    sv_day2.setVisibility(View.VISIBLE);
                    sv_day3.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_day3:
                    sv_day1.setVisibility(View.INVISIBLE);
                    sv_day2.setVisibility(View.INVISIBLE);
                    sv_day3.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    public Schedule() {
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
        View schedule = inflater.inflate(R.layout.activity_tabbed, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Schedule");

        sv_day1 = (ScrollView)schedule.findViewById(R.id.sv_day1);
        sv_day2 = (ScrollView)schedule.findViewById(R.id.sv_day2);
        sv_day3 = (ScrollView)schedule.findViewById(R.id.sv_day3);

        BottomNavigationView navigation = (BottomNavigationView) schedule.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        return schedule;
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
}
