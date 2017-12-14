package com.paresh.exodia.Events;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paresh.exodia.MainActivity;
import com.paresh.exodia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListTechnicalList extends Fragment {

    private boolean viewIsAtHome;
    Bundle bundle = new Bundle();
    private int i;
    Fragment fragment = new EventList();


    public EventListTechnicalList() {
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
        View event_list_fragment_tech = inflater.inflate(R.layout.events_fragment_list_technical_list, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Technical Events");
        i =getArguments().getInt("key");
        Log.d("int",String.valueOf(i));

        ViewPager viewPager = (ViewPager) event_list_fragment_tech.findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapterEventsTechnical adapter = new SimpleFragmentPagerAdapterEventsTechnical(getContext(), getActivity().getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) event_list_fragment_tech.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(i);
        bundle.putInt("key",0);
        fragment.setArguments(bundle);

        return event_list_fragment_tech;
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
