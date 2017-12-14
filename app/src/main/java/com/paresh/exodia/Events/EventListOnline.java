package com.paresh.exodia.Events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListOnline extends Fragment {


    public EventListOnline() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.events_fragment_list_online, container, false);
        return rootView;
    }

}
