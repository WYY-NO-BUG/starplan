package com.demo.starplan.history;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.starplan.R;
import com.demo.starplan.bean.Babybus;
import com.demo.starplan.recommend.BabybusAdapter;
import com.demo.starplan.mvp.BaseMvpActivity;

import java.util.List;

import static org.litepal.LitePalApplication.getContext;

/**
 * 无须重写适配器
 * 采用和推荐页相同适配器
 *
 * 通过传入type不同，实现不同效果
 * type = 5
 * 采用线形layoutmanager*/
public class HistoryActivity extends BaseMvpActivity<HistoryPresenter> implements HistoryContract.View{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mPresenter = new HistoryPresenter(this);

        requestData();
    }


    @Override
    public void requestData() {
        mPresenter.getMessage();
    }

    @Override
    public void showView(List<Babybus> babybusList) {
        recyclerView = findViewById(R.id.recycler_history);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final BabybusAdapter adapter = new BabybusAdapter(babybusList, getContext());
        recyclerView.setAdapter(adapter);
    }
}
