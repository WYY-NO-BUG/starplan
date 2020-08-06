package com.demo.starplan.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.starplan.R;
import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.BaseMvpFragment;

import java.util.List;

public class RecommendedFragment extends BaseMvpFragment<RecommendedPresenter> implements RecommendedContract.View {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recommended, container, false);
        mPresenter = new RecommendedPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestData();

    }

    @Override
    public void requestData() {
        mPresenter.getMessage();
    }


    /**
     * 计算最大公约数
     * 得到每一个item所占位置
     **/
    @Override
    public void showView(final List<Babybus> babybusList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView = view.findViewById(R.id.recycler_view);
                GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 10);

                //spancount/spansize = 列数
                layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        Babybus bbb = babybusList.get(position);
                        if (bbb.type == Babybus.TypeOne) {
                            return 10;
                        } else if (bbb.type == Babybus.TypeTwo) {
                            return 2;
                        } else if (bbb.type == Babybus.TypeThree) {
                            return 10;
                        } else if (bbb.type == Babybus.TypeFour) {
                            return 5;
                        } else return 0;
                    }
                });
                recyclerView.setLayoutManager(layoutManager);
                BabybusAdapter adapter = new BabybusAdapter(babybusList, getContext());
                recyclerView.setAdapter(adapter);

            }
        });
    }


}
