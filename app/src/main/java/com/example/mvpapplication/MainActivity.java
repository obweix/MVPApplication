package com.example.mvpapplication;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mvpapplication.bean.BaseBean;
import com.example.mvpapplication.bean.Goods;
import com.example.mvpapplication.bean.network.GoodsService;
import com.example.mvpapplication.bean.network.RetrofitClient;
import com.example.mvpapplication.ui.base.BaseActivity;
import com.example.mvpapplication.ui.cart.CartFragment;
import com.example.mvpapplication.ui.home.HomeFragement;
import com.example.mvpapplication.ui.mine.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Fragment[] fragments;
    private int lastFragmentIndex = 0;

    private static final String TAG = "MainActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_MVPApplication);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
      BottomNavigationView bottomNavigationView =  find(R.id.main_buttom_navigation);
      bottomNavigationView.setOnNavigationItemSelectedListener(this);

      fragments = new Fragment[]{
              new HomeFragement(),
              new CartFragment(),
              new MineFragment()
      };

     for(Fragment fragment : getSupportFragmentManager().getFragments()){
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
     }

      getSupportFragmentManager().beginTransaction().add(R.id.main_frame, fragments[0]).commit();

    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: MainActivity");

        if(fragments[0].isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .remove(fragments[0])
                    .commitAllowingStateLoss();
        }

        fragments = null;

        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.buttom_home:
                switchFragment(0);
                break;
            case R.id.buttom_cart:
                switchFragment(1);
                break;
            case R.id.buttom_mine:
                switchFragment(2);
                break;
        }
        return false;
    }

    private void switchFragment(int to){
        if(lastFragmentIndex == to){
            return;
        }

        FragmentTransaction fragmentTransaction =  getSupportFragmentManager()
                .beginTransaction();
        if(!fragments[to].isAdded()){
           fragmentTransaction.add(R.id.main_frame,fragments[to]);
        }else{
            fragmentTransaction.show(fragments[to]);
        }
//        fragmentTransaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        fragmentTransaction.hide(fragments[lastFragmentIndex]).commit();

        lastFragmentIndex = to;
    }


}