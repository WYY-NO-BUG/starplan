package com.demo.starplan.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.demo.starplan.R;
import com.demo.starplan.goodstudy.WatchFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class WatchFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewpager;
    private View view;
    private WatchFragmentPagerAdapter mWatchFragmentPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_watch, container, false);
        mTabLayout = view.findViewById(R.id.tl_wt);
        mViewpager = view.findViewById(R.id.vp_wt);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWatchFragmentPagerAdapter = new WatchFragmentPagerAdapter(getChildFragmentManager());
        mViewpager.setAdapter(mWatchFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewpager);

        for(int i = 0;i < mTabLayout.getTabCount();i++){
            mTabLayout.getTabAt(i);
        }
    }


}
