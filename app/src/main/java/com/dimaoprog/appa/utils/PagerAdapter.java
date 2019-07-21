package com.dimaoprog.appa.utils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dimaoprog.appa.view.history.HistoryFragment;
import com.dimaoprog.appa.view.test.TestFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private ISendBroadcastListener sendBroadcastListener;
    private ISetHistoryFragmentListener setHistoryFragmentListener;

    public PagerAdapter(FragmentManager fm, ISendBroadcastListener sendBroadcastListener,
                        ISetHistoryFragmentListener setHistoryFragmentListener) {
        super(fm);
        this.sendBroadcastListener = sendBroadcastListener;
        this.setHistoryFragmentListener = setHistoryFragmentListener;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return HistoryFragment.newInstance(sendBroadcastListener, setHistoryFragmentListener);
        } else {
            return TestFragment.newInstance(sendBroadcastListener);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 1) {
            return "History";
        } else {
            return "Test";
        }
    }
}
