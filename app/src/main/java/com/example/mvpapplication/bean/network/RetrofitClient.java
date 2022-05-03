package com.example.mvpapplication.bean.network;

import com.example.mvpapplication.R;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  volatile RetrofitClient mInstance;
//    private static final String BASE_RUL = "https://raw.githubusercontent.com/";
    private static final String BASE_RUL = "https://gitee.com/fromis_9/test/raw/";
    private static final String BASE_RUL2 = "https://h5.48.cn/";
    private Retrofit retrofit;

    private RetrofitClient(){}

    public static RetrofitClient getInstance(){
        if(null == mInstance){
            synchronized (RetrofitClient.class){
                if(null == mInstance){
                    mInstance = new RetrofitClient();
                }
            }
        }
        return  mInstance;
    }

    public <T> T getService(Class<T> tClass){
        return getRetrofit().create(tClass);
    }

    private Retrofit getRetrofit(){
        if (null == retrofit){
            retrofit = new Retrofit.Builder().baseUrl(BASE_RUL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public <T> T getService2(Class<T> tClass){
        return getRetrofit2().create(tClass);
    }

    private Retrofit getRetrofit2(){
        if (null == retrofit){
            retrofit = new Retrofit.Builder().baseUrl(BASE_RUL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }



}
