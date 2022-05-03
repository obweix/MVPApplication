package com.example.mvpapplication.ui.home;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvpapplication.R;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.ui.base.BaseFragment;
import com.example.mvpapplication.ui.home.adapter.HomeRecyclerViewAdapter;
import com.example.mvpapplication.ui.home.adapter.HomeSpanSizeLookup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragement extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, HomeContract.IHomeView {
    private  HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private  HomePresenter homePresenter;
    private HomeSpanSizeLookup homeSpanSizeLookup;

    @Override
    protected void initView() {
        SwipeRefreshLayout swipeRefreshLayout = find(R.id.home_swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = find(R.id.home_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),4);
        List<Goods> goods = new ArrayList<Goods>();
        homeSpanSizeLookup = new HomeSpanSizeLookup(goods);
        gridLayoutManager.setSpanSizeLookup(homeSpanSizeLookup);

        recyclerView.setLayoutManager(gridLayoutManager);

        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(),goods);
        recyclerView.setAdapter(homeRecyclerViewAdapter);

         homePresenter = new HomePresenter(this);
         homePresenter.getData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onRefresh() {
        homePresenter.getData();
    }

    @Override
    public void getGoodsSuccess(List<Goods> goods) {
        System.out.println("????????");

        homeSpanSizeLookup.setGoods(goods);

        homeRecyclerViewAdapter.setGoods(goods);
    }

    @Override
    public void getGoodsError(Throwable throwable) {
        System.out.println("不抛出异常");
    }
}
