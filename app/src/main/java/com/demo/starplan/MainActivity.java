package com.demo.starplan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化视图
        initViews();

    }
    private void initViews(){
        //绑定viewpager和Fragment
        viewPager = findViewById(R.id.viewpager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentPagerAdapter);

        //绑定tablayout与viewpager
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        //设置tab位置
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
        four = tabLayout.getTabAt(3);

        //设置tab图标
/*        one.setIcon();
        two.setIcon();
        three.setIcon();
        four.setIcon();*/
    }
}
