package com.example.mvpapplication.ui.home;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvpapplication.R;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.bean.GoodsDetail;
import com.example.mvpapplication.ui.base.BaseFragment;
import com.example.mvpapplication.ui.detail.GoodsDetailActivity;
import com.example.mvpapplication.ui.home.adapter.HomeRecyclerViewAdapter;
import com.example.mvpapplication.ui.home.adapter.HomeSpanSizeLookup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragement extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, HomeContract.IHomeView,HomeRecyclerViewAdapter.OnItemClickListener{
    private  HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private  HomePresenter homePresenter;
    private HomeSpanSizeLookup homeSpanSizeLookup;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static final String TAG = "HomeFragement";

    @Override
    protected void initView() {
         swipeRefreshLayout = find(R.id.home_swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = find(R.id.home_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),4);
        List<Goods> goods = new ArrayList<Goods>();
        homeSpanSizeLookup = new HomeSpanSizeLookup(goods);
        gridLayoutManager.setSpanSizeLookup(homeSpanSizeLookup);

        recyclerView.setLayoutManager(gridLayoutManager);

        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(recyclerView,getActivity(),goods);
        homeRecyclerViewAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(homeRecyclerViewAdapter);

         homePresenter = new HomePresenter(this);
         homePresenter.getData();
        Log.w(TAG, "initView: get Data()");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        homePresenter.getData();
    }

    @Override
    public void getGoodsSuccess(List<Goods> goods) {
        homeSpanSizeLookup.setGoods(goods);

        homeRecyclerViewAdapter.setGoods(goods);
    }

    @Override
    public void getGoodsError(Throwable throwable) {
        System.out.println("不抛出异常");
    }

    @Override
    public void onItemClick(Goods goods) {
//        Log.i(TAG, "onItemClick: " + goods);
        Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
        intent.putExtra(GoodsDetailActivity.GOODS_ID,goods.getGoodsId());
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: HomeFragment destroy---------------------------");
        super.onDestroy();
    }
}
