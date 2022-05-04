package com.example.mvpapplication.ui.detail;

import android.util.Log;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.GoodsDetail;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GoodsDetailPresenter implements GoodsDetailContract.IGoodDetailPresenter {
    GoodsDetailContract.IGoodDetailModel goodDetailModel;
    GoodsDetailContract.IGoodDetailView goodDetailView;

    public GoodsDetailPresenter(GoodsDetailContract.IGoodDetailView goodDetailView){
        goodDetailModel = new GoodsDetailModel();
        this.goodDetailView = goodDetailView;
    }

    @Override
    public void getGoodsDetail(int goodsId) {
        goodDetailModel.getGoodsDetail(goodsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<GoodsDetail>>() {
                    @Override
                    public void accept(BaseBean<GoodsDetail> goodsDetailBaseBean) throws Throwable {
                        goodDetailView.getGoodsDetailSuccess(goodsDetailBaseBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        goodDetailView.getGoodsDetailError(throwable);
                    }
                });

    }
}
