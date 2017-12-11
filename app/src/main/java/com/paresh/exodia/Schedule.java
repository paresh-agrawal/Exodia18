package com.paresh.exodia;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Schedule extends Fragment {

    private ScrollView sv_day1,sv_day2,sv_day3;
    private List<ScheduleList> scheduleListListDay1 = new ArrayList<>(),
            scheduleListListDay2 = new ArrayList<>(),scheduleListListDay3 = new ArrayList<>();
    private RecyclerView recyclerViewDay1,recyclerViewDay2,recyclerViewDay3;
    private ScheduleAdapter mAdapterDay1,mAdapterDay2,mAdapterDay3;
    private ScheduleList scheduleListDay1,scheduleListDay2,scheduleListDay3;
    private ProgressBar progressBar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Schedule");

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
        View schedule = inflater.inflate(R.layout.fragment_schedule, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Schedule");

        sv_day1 = (ScrollView)schedule.findViewById(R.id.sv_day1);
        sv_day2 = (ScrollView)schedule.findViewById(R.id.sv_day2);
        sv_day3 = (ScrollView)schedule.findViewById(R.id.sv_day3);

        progressBar = (ProgressBar)schedule.findViewById(R.id.progressBar);

        recyclerViewDay1 = (RecyclerView) schedule.findViewById(R.id.recycler_view_schedule_day1);
        recyclerViewDay2 = (RecyclerView) schedule.findViewById(R.id.recycler_view_schedule_day2);
        recyclerViewDay3 = (RecyclerView) schedule.findViewById(R.id.recycler_view_schedule_day3);

        mAdapterDay1 = new ScheduleAdapter(scheduleListListDay1);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewDay1.setLayoutManager(mLayoutManager1);
        recyclerViewDay1.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDay1.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerViewDay1.setAdapter(mAdapterDay1);

        mAdapterDay2 = new ScheduleAdapter(scheduleListListDay2);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewDay2.setLayoutManager(mLayoutManager2);
        recyclerViewDay2.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDay2.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerViewDay2.setAdapter(mAdapterDay2);

        mAdapterDay3 = new ScheduleAdapter(scheduleListListDay3);
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewDay3.setLayoutManager(mLayoutManager3);
        recyclerViewDay3.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDay3.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerViewDay3.setAdapter(mAdapterDay3);


        prepareScheduleDataDay1();
        prepareScheduleDataDay2();
        prepareScheduleDataDay3();

        BottomNavigationView navigation = (BottomNavigationView) schedule.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        return schedule;
    }

    private void prepareScheduleDataDay1() {
        // Read from the database
        progressBar.setVisibility(View.VISIBLE);

        myRef.child("Day1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                scheduleListListDay1.clear();
                String[] event_name = new String[20],event_time = new String[20],
                        event_venue = new String[20];
                int i = 0;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    event_name[i] = dsp.getKey().toString();
                    event_time[i] = dsp.child("time").getValue().toString();
                    event_venue[i] = dsp.child("venue").getValue().toString();
                    i++;

                }
                int j=0;
                for(j=0;j<i;j++) {
                    scheduleListDay1 = new ScheduleList(event_name[j], event_venue[j], event_time[j]);
                    scheduleListListDay1.add(scheduleListDay1);
                }
                Collections.sort(scheduleListListDay1,
                        (l1, l2) -> l1.getEvent_time().compareTo(l2.getEvent_time()));
                progressBar.setVisibility(View.INVISIBLE);
                mAdapterDay1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value", "Failed to read value.", error.toException());
            }
        });
    }

    private void prepareScheduleDataDay2() {
        // Read from the database

        progressBar.setVisibility(View.VISIBLE);
        myRef.child("Day2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                scheduleListListDay2.clear();
                String[] event_name = new String[20],event_time = new String[20],
                        event_venue = new String[20];
                int i = 0;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    event_name[i] = dsp.getKey().toString();
                    event_time[i] = dsp.child("time").getValue().toString();
                    event_venue[i] = dsp.child("venue").getValue().toString();
                    i++;

                }
                int j=0;
                for(j=0;j<i;j++) {
                    scheduleListDay2 = new ScheduleList(event_name[j], event_venue[j], event_time[j]);
                    scheduleListListDay2.add(scheduleListDay2);
                }
                Collections.sort(scheduleListListDay2,
                        (l1, l2) -> l1.getEvent_time().compareTo(l2.getEvent_time()));

                progressBar.setVisibility(View.INVISIBLE);
                mAdapterDay2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value", "Failed to read value.", error.toException());
            }
        });
    }

    private void prepareScheduleDataDay3() {
        // Read from the database

        progressBar.setVisibility(View.VISIBLE);
        myRef.child("Day3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                scheduleListListDay3.clear();
                String[] event_name = new String[20],event_time = new String[20],
                        event_venue = new String[20];
                int i = 0;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    event_name[i] = dsp.getKey().toString();
                    event_time[i] = dsp.child("time").getValue().toString();
                    event_venue[i] = dsp.child("venue").getValue().toString();
                    i++;

                }
                int j=0;
                for(j=0;j<i;j++) {
                    scheduleListDay3 = new ScheduleList(event_name[j], event_venue[j], event_time[j]);
                    scheduleListListDay3.add(scheduleListDay3);
                }
                Collections.sort(scheduleListListDay3,
                        (l1, l2) -> l1.getEvent_time().compareTo(l2.getEvent_time()));
                progressBar.setVisibility(View.INVISIBLE);
                mAdapterDay3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value", "Failed to read value.", error.toException());
            }
        });
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
