package com.example.mvpapplication.bean.network;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;

public interface TeamService {
    @GET("resource/jsonp/allmembers.php?gid=00")
    Flowable<Team> getGoods();
}
