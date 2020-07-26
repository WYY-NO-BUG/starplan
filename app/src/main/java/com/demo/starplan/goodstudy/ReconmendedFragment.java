
package com.demo.starplan.goodstudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demo.starplan.R;

import java.util.ArrayList;
import java.util.List;


public class ReconmendedFragment extends Fragment {
    private View view;
    private List<babybus> babybusList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recommended, container, false);
        initApp();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),20);

        //spancount/spansize = 列数
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                babybus bbb = babybusList.get(position);
                if (bbb.type== babybus.TypeOne){
                    return 20;
                }else if (bbb.type == babybus.TypeTwo){
                    return 4;
                }else if (bbb.type== babybus.TypeThree){
                    return 20;
                }else if (bbb.type == babybus.TypeFour){
                    return 10;
                }else return 0;
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        BabybusAdapter adapter = new BabybusAdapter(babybusList,getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void initApp() {

        babybus one = new babybus("儿歌", R.drawable.iv_cartoon_normal,1);
        babybusList.add(one);
        babybus t = new babybus("推荐", R.drawable.iv_cartoon_normal,4);
        babybusList.add(t);
        babybus q = new babybus("儿歌", R.drawable.iv_cartoon_normal,4);
        babybusList.add(q);
        babybus w = new babybus("儿歌", R.drawable.iv_cartoon_normal,4);
        babybusList.add(w);
        babybus e = new babybus("儿歌", R.drawable.iv_cartoon_normal,4);
        babybusList.add(e);

    }
}