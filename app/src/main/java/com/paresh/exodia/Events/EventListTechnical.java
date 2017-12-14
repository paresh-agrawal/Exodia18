package com.paresh.exodia.Events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.paresh.exodia.Home;
import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListTechnical extends Fragment {

    private boolean viewIsAtHome;
    private Fragment fragment = new EventListTechnicalList();

    public EventListTechnical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.events_fragment_list_technical, container, false);

        RelativeLayout rl_tech_events_event1 = (RelativeLayout) rootView.findViewById(R.id.rl_tech_events_event1);
        RelativeLayout rl_tech_events_event2 = (RelativeLayout) rootView.findViewById(R.id.rl_tech_events_event2);
        RelativeLayout rl_tech_events_event3 = (RelativeLayout) rootView.findViewById(R.id.rl_tech_events_event3);

        rl_tech_events_event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.rl_tech_events_event1);
            }
        });
        rl_tech_events_event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.rl_tech_events_event2);
            }
        });
        rl_tech_events_event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.rl_tech_events_event3);
            }
        });
        return rootView;
    }
    public void displayView(int viewId) {

        String title = getString(R.string.app_name);
        Bundle bundle = new Bundle();
        switch (viewId) {

            case R.id.rl_tech_events_event1:
                bundle.putInt("key",0);
                break;
            case R.id.rl_tech_events_event2:
                bundle.putInt("key",1);
                break;
            case R.id.rl_tech_events_event3:
                bundle.putInt("key",2);
                break;

        }
        fragment.setArguments(bundle);
        viewIsAtHome = true;
        title  = "Events";
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
