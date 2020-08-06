package com.demo.starplan.history;

import com.demo.starplan.database.HistoryPlay;
import com.demo.starplan.bean.Babybus;
import com.demo.starplan.mvp.Callback;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class HistoryModel implements HistoryContract.Model {

    private List<HistoryPlay> historyPlayList;
    private List<Babybus> babybusList = new ArrayList<>();

    @Override
    public void getData(Callback callback) {
        historyPlayList = LitePal.order("id desc").find(HistoryPlay.class);
        if (historyPlayList.size() > 0){
            for (HistoryPlay history : historyPlayList
            ) {
                babybusList.add(new Babybus(history.getName(),history.getTitle(),history.getUrlImg(),history.getDate(),5));
            }
        }
        callback.onSuccess(babybusList);
    }
}
