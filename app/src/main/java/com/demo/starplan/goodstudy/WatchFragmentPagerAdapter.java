package com.demo.starplan.goodstudy;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.demo.starplan.recommend.RecommendedFragment;


public class WatchFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] titles = new String[]{"推荐","儿歌","动画","音乐剧","启蒙"};

    public WatchFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1){
            return new SongFragment();
        } else if (position == 2) {
            return new CartoonFragment();
        } else if(position == 3) {
            return new MusicFragment();
        } else  if (position == 4) {
            return new EnlightenmentFragment();
        }
        return new RecommendedFragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
