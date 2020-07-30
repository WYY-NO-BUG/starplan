package com.demo.starplan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private NoScrollViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private int[] pics = new int[]{R.drawable.iv_cartoon_normal, R.drawable.iv_app_normal,
            R.drawable.iv_listen_normal, R.drawable.iv_mine_normal,};

    private ImageView historyPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        historyPlay = findViewById(R.id.iv_history);
        historyPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

        //初始化视图
        initViews();


    }



    private void initViews() {
        //绑定viewpager和Fragment
        viewPager = findViewById(R.id.viewpager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(myFragmentPagerAdapter);

        //绑定tablayout与viewpager
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        /*for(int i=0;i<myFragmentPagerAdapter.getCount();i++){
            tabLayout.getTabAt(i).setIcon(pics[i]);
        }*/
        for(int i = 0;i < tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setCustomView(myFragmentPagerAdapter.getTabView(i));
        }
        tabLayout.getTabAt(0).getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_cartoon_select);


        /*for (int i = 0; i < myFragmentPagerAdapter.getCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(myFragmentPagerAdapter.getTabView(i));
        }*/

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_cartoon_select);
                        break;
                    case 1:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_app_select);
                        break;
                    case 2:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_listen_select);
                        break;
                    case 3:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_mine_select);
                        break;
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_cartoon_normal);
                        break;
                    case 1:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_app_normal);
                        break;
                    case 2:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_listen_normal);
                        break;
                    case 3:
                        tab.getCustomView().findViewById(R.id.iv_title).setBackgroundResource(R.drawable.iv_mine_normal);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
