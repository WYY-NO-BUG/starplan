
package com.demo.starplan.goodstudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demo.starplan.R;
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
        initApp();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
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
        BabybusAdapter adapter = new BabybusAdapter(babybusList, getContext());
        recyclerView.setAdapter(adapter);
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
//        Gson gson = new Gson();
//        List<BabyBusBean> babyBusBeanList = gson.fromJson(jsonDate,
//                    new TypeToken<List<BabyBusBean>>(){}.getType());
//        for (BabyBusBean bbb: babyBusBeanList
//             ) {
//            babybusList.add(bbb);
//        }
    }

    public void initApp() {
        babybusList = new ArrayList<>();
        babybus one = new babybus("儿歌", R.drawable.iv_cartoon_normal, 1);
        babybusList.add(one);
        babybus a = new babybus("吃饭", R.drawable.iv_cartoon_normal, 2);
        babybusList.add(a);
        babybus s = new babybus("哄睡", R.drawable.iv_cartoon_normal, 2);
        babybusList.add(s);
        babybus d = new babybus("奇妙课堂", R.drawable.iv_cartoon_normal, 2);
        babybusList.add(d);
        babybus f = new babybus("绘本故事", R.drawable.iv_cartoon_normal, 2);
        babybusList.add(f);
        babybus g = new babybus("VIP会员", R.drawable.iv_cartoon_normal, 2);
        babybusList.add(g);
        babybus h = new babybus("儿歌精选", R.drawable.iv_cartoon_normal, 3);
        babybusList.add(h);
        babybus t = new babybus("经点儿歌100首", R.drawable.iv_cartoon_normal, 4);
        babybusList.add(t);
        babybus q = new babybus("流行童谣", R.drawable.iv_cartoon_normal, 4);
        babybusList.add(q);
        babybus w = new babybus("蜜蜜一家", R.drawable.iv_cartoon_normal, 4);
        babybusList.add(w);
        babybus e = new babybus("疯狂怪兽车", R.drawable.iv_cartoon_normal, 4);
        babybusList.add(e);

    }
}