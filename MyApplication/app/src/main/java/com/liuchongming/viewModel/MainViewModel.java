package com.liuchongming.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.liuchongming.intf.IUser;
import com.liuchongming.beans.UserBean;
import com.liuchongming.myapplication.RecyclerViewActivity;
import com.liuchongming.myapplication.RegResult;
import com.liuchongming.utils.SSLHelper;
import com.liuchongming.utils.UnSafeHostnameVerifier;

import java.util.Date;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuchongming on 2016/11/23.
 * Project Name: MyApplication
 * Package Mame: ${PACKAGE_NAME}
 */

public class MainViewModel implements ViewModel {
    private Context context;
    private UserBean user;
    private ObservableBoolean agree;
    private final static String TAG = "MainViewModel.class";

    public MainViewModel(Context context) {
        this.context = context;
        this.user = new UserBean();
        this.agree = new ObservableBoolean();
    }

    public final ReplyCommand agreeCommand = new ReplyCommand(() -> {
        agree.set(agree.get() ? false : true);
        testSSL();
    });

    public final ReplyCommand resetCommand = new ReplyCommand(() -> {
        user.setPassword("");
        user.setName("");
        user.setPhone("");
        context.startActivity(new Intent(context, RecyclerViewActivity.class));
    });

    public final ReplyCommand regCommand = new ReplyCommand(() -> {
        user.setDate(new Date());
        context.startActivity(new Intent(context, RegResult.class).putExtra("user", user));
    });

    public UserBean getUser() {
        return user;
    }

    public ObservableBoolean getAgree() {
        return agree;
    }

    private void testSSL() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(SSLHelper.getSSLCertifcation(context))
                .hostnameVerifier(new UnSafeHostnameVerifier())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://10.2.8.3:8443")
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .client(okHttpClient)
                .build();

        IUser userIntf = retrofit.create(IUser.class);
        userIntf.login("username", "password")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserBean>() {
                    @Override
                    public void onCompleted() {
                        //自定义回调
                    }

                    @Override
                    public void onError(Throwable e) {
                        //自定义错误处理
                    }

                    @Override
                    public void onNext(UserBean userModel) {
                        user.setName(userModel.getName());
                        user.setPhone(userModel.getPhone());
                        user.setPassword(userModel.getPassword());
                        user.setDate(userModel.getDate());
                    }
                });
    }
}