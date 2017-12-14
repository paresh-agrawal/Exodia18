package com.paresh.exodia.Events;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.paresh.exodia.Home;
import com.paresh.exodia.MainActivity;
import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    private boolean viewIsAtHome;
    private Fragment fragment = new EventList();

    public EventFragment() {
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
        View event_fragment = inflater.inflate(R.layout.events_fragment, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Events");

        RelativeLayout rl_tech_events = (RelativeLayout)event_fragment.findViewById(R.id.rl_tech_events);
        RelativeLayout rl_cult_events = (RelativeLayout)event_fragment.findViewById(R.id.rl_cult_events);

        rl_tech_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.rl_tech_events);
            }
        });
        rl_cult_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(R.id.rl_cult_events);
            }
        });

        return event_fragment;
    }

    public void displayView(int viewId) {

        String title = getString(R.string.app_name);
        Bundle bundle = new Bundle();
        switch (viewId) {

            case R.id.rl_tech_events:
                bundle.putInt("key",0);
                break;
            case R.id.rl_cult_events:
                bundle.putInt("key",1);
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
