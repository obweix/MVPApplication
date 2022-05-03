package com.example.mvpapplication.bean.network;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodsService {

//    @GET("edu-lance/edu-lance.github.io/master/goods_list")
    @GET("master/goods_list.json")
    Flowable<BaseBean<List<Goods>>> getGoods();

    @GET("edu-lance/edu-lance.github.io/master/goods_detail")
    Flowable<BaseBean<List<Goods>>> getGoodsDetail(@Query("goodId") int goodsId);
}
