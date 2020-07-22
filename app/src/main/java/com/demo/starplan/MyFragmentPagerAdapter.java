package com.demo.starplan;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"好看","好听","好学","我的"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1){
            return new listen();
        } else if (position ==2 ) {
            return new learn();
        } else if (position == 3) {
            return new mine();
        }
        return new watch();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    //viewPager 与 TabLayout绑定后，这里获取到的pagertiles就是tab的text
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
