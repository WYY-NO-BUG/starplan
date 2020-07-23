package com.demo.starplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"好看", "好听", "好学", "我的"};
    private int[] pics = new int[]{R.drawable.iv_cartoon_normal, R.drawable.iv_app_normal,
            R.drawable.iv_listen_normal, R.drawable.iv_mine_normal,};

    private Context mContext;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new ListenFragment();
        } else if (position == 2) {
            return new LearnFragment();
        } else if (position == 3) {
            return new MineFragment();
        }
        return new WatchFragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    //viewPager 和TabLayout绑定后，这里获取到的PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Nullable
    public View getTabView(int position) {

        View tabView = LayoutInflater.from(mContext).inflate(R.layout.item_titles, null);
        LinearLayout TabTitle = tabView.findViewById(R.id.tab_title);
        TextView textView = tabView.findViewById(R.id.tv_title);
        ImageView imageView = tabView.findViewById(R.id.iv_title);
        textView.setText(titles[position]);
        imageView.setImageResource(pics[position]);


        return tabView;
    }
}
