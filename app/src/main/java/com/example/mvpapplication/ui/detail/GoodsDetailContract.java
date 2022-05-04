package com.example.mvpapplication.ui.detail;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.bean.GoodsDetail;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface GoodsDetailContract {
    interface IGoodDetailPresenter{
        void getGoodsDetail(int goodsId);
    }

    interface IGoodDetailModel{
        Flowable<BaseBean<GoodsDetail>> getGoodsDetail(int goodsId);
    }

    interface IGoodDetailView{

        void getGoodsDetailSuccess(GoodsDetail goods);

        void getGoodsDetailError(Throwable throwable);

    }
}
