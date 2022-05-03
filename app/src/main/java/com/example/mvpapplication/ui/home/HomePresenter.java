package com.example.mvpapplication.ui.home;

import android.util.Log;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter implements  HomeContract.IHomePresenter{

    private HomeContract.IHomeView homeView;
    private HomeContract.IHomeModel homeModel ;

    public HomePresenter(HomeContract.IHomeView homeView){
        this.homeView = homeView;
        this.homeModel = new HomeModel();
    }

    @Override
    public void getData() {
        Log.d("msg","getData1");

        homeModel.getData().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<BaseBean<List<Goods>>>() {
            @Override
            public void accept(BaseBean<List<Goods>> listBaseBean) throws Throwable {
                Log.d("msg","getData2");
                System.out.println(listBaseBean.toString());
                homeView.getGoodsSuccess(listBaseBean.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                Log.d("msg","getData3");
                homeView.getGoodsError(throwable);
            }
        })
        ;
    }
}
