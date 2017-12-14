package com.paresh.exodia.Events;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.paresh.exodia.R;

/**
 * Created by paresh on 13/12/17.
 */

public class SimpleFragmentPagerAdapterEventsTechnical extends FragmentStatePagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapterEventsTechnical(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EventListTechnicalListRobowar();
        } else if (position == 1){
            return new EventListTechnicalListLineFollower();
        } else if (position == 2){
            return new EventListTechnicalListJunkyardWars();
        } else if (position == 3){
            return new EventListTechnicalListLineFollower();
        } else {
            return new EventListTechnicalListJunkyardWars();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 5;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.robowars);
            case 1:
                return mContext.getString(R.string.line_follower);
            case 2:
                return mContext.getString(R.string.junkyard_wars);
            case 3:
                return mContext.getString(R.string.junkyard_wars);
            case 4:
                return mContext.getString(R.string.junkyard_wars);
            default:
                return null;
        }
    }

}
