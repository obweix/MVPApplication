package com.example.mvpapplication.ui.home;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class LocalModel implements HomeContract.IHomeModel {
    @Override
    public Flowable<BaseBean<List<Goods>>> getData() {

        // 从本地缓存获取
        return null;
    }
}
