package com.example.mvpapplication.ui.detail;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mvpapplication.R;
import com.example.mvpapplication.bean.GoodsDetail;
import com.example.mvpapplication.ui.base.BaseActivity;

public class GoodsDetailActivity extends BaseActivity implements View.OnClickListener,GoodsDetailContract.IGoodDetailView {
    public static final String GOODS_ID  = "goods_id";
    private GoodsDetailPresenter goodsDetailPresenter;
    private Toolbar toolbar;
    private TextView detailContent;

    @Override
    protected void initView() {
        toolbar = find(R.id.detail_toolbar);
        detailContent = find(R.id.detail_textview);
        toolbar.setNavigationOnClickListener(this);
        int goodId = getIntent().getIntExtra(GOODS_ID,0);

        goodsDetailPresenter = new GoodsDetailPresenter(this);

        goodsDetailPresenter.getGoodsDetail(goodId);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_ldetail;
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void getGoodsDetailSuccess(GoodsDetail goods) {
        toolbar.setTitle(goods.getName());
        detailContent.setText(goods.getDescription());
    }

    @Override
    public void getGoodsDetailError(Throwable throwable) {
        Toast.makeText(this,"获取商品详情失败",Toast.LENGTH_SHORT).show();
    }
}
