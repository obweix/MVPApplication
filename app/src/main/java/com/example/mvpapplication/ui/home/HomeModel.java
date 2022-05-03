package com.example.mvpapplication.ui.home;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.bean.network.GoodsService;
import com.example.mvpapplication.bean.network.RetrofitClient;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class HomeModel implements HomeContract.IHomeModel{

    //
    @Override
    public Flowable<BaseBean<List<Goods>>> getData() {
        return RetrofitClient.getInstance().getService(GoodsService.class).getGoods();
    }
}
