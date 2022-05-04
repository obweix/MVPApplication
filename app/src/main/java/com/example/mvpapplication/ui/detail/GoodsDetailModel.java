package com.example.mvpapplication.ui.detail;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.bean.GoodsDetail;
import com.example.mvpapplication.bean.network.GoodsService;
import com.example.mvpapplication.bean.network.RetrofitClient;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class GoodsDetailModel implements GoodsDetailContract.IGoodDetailModel {

    @Override
    public Flowable<BaseBean<GoodsDetail>> getGoodsDetail(int goodsId) {
        return RetrofitClient.getInstance().getService(GoodsService.class).getGoodsDetail(goodsId);
    }
}
