
package com.demo.starplan.goodstudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demo.starplan.R;
import com.demo.starplan.httpdemo.ReturnImg;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ReconmendedFragment extends Fragment {
    private View view;
    private List<babybus> babybusList;
    private BabyBusBean babyBusBean;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_recommended, container, false);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendRequestWithOkHttp();

        recyclerView = view.findViewById(R.id.recycler_view);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 10);

        //spancount/spansize = 列数
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                babybus bbb = babybusList.get(position);
                if (bbb.type == babybus.TypeOne) {
                    return 10;
                } else if (bbb.type == babybus.TypeTwo) {
                    return 2;
                } else if (bbb.type == babybus.TypeThree) {
                    return 10;
                } else if (bbb.type == babybus.TypeFour) {
                    return 5;
                } else return 0;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

    }

    private void sendRequestWithOkHttp() {
        //开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://gitee.com/qfxl/star_project/raw/master/forTest.json")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWith(responseData);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://gitee.com/qfxl/star_project/raw/master/forTest.json")
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//
//            }
//        });
    }

    private void parseJSONWith(String jsonDate) {
        Gson gson = new Gson();
        babyBusBean = gson.fromJson(jsonDate, BabyBusBean.class);
        try {
            initApp();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    BabybusAdapter adapter = new BabybusAdapter(babybusList, getContext());
                    recyclerView.setAdapter(adapter);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initApp() throws IOException {
        babybusList = new ArrayList<>();
        for (BabyBusBean.DataBean.RecommendListBean BDR : babyBusBean.getData().getRecommendList()) {

            babybusList.add(new babybus(BDR.getSerialInfo(), BDR.getImg(),1));
            break;
        }
        for (BabyBusBean.DataBean.SubjectListBean BDR : babyBusBean.getData().getSubjectList()){
            babybusList.add(new babybus(BDR.getName(), BDR.getImg(),2));
        }
        for (BabyBusBean.DataBean.EliteListBean BDR : babyBusBean.getData().getEliteList()){
            babybusList.add(new babybus(BDR.getName(), BDR.getImg(),3));
        }
        for (BabyBusBean.DataBean.EliteListBean.ListBean BDR : babyBusBean.getData().getEliteList().get(0).getList()){
            babybus bbb = new babybus(BDR.getName(), BDR.getImg(),4);
            bbb.setDesc(BDR.getDesc());
            babybusList.add(bbb);
        }


    }
}