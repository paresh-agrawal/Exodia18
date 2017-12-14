package com.paresh.exodia.Events;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.paresh.exodia.R;

/**
 * Created by paresh on 13/12/17.
 */

public class SimpleFragmentPagerAdapterEvents extends FragmentStatePagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapterEvents(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EventListTechnical();
        } else if (position == 1){
            return new EventListCultural();
        } else {
            return new EventListOnline();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.technical);
            case 1:
                return mContext.getString(R.string.cultural);
            case 2:
                return mContext.getString(R.string.online);
            default:
                return null;
        }
    }

}
