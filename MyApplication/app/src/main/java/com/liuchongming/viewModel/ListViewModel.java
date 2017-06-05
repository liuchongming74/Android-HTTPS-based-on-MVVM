package com.liuchongming.viewModel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.liuchongming.beans.Contributor;
import com.liuchongming.intf.GitHub;
import com.liuchongming.utils.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuchongming on 2016/11/28.
 * Project Name: MyApplication
 * Package Mame: com.liuchongming.viewModel
 */

public class ListViewModel implements ViewModel {
    private Context context;
    private ObservableList<Contributor> data = new ObservableArrayList<>();
    public RecyclerViewAdapter adapter;

    public ListViewModel(Context context) {
        this.context = context;
        fetchList();
        this.adapter = new RecyclerViewAdapter(data);
    }

    public final ReplyCommand floatBtn = new ReplyCommand(() -> {
        Toast.makeText(context, "Replace with your own action", Toast.LENGTH_LONG).show();
    });

    private void fetchList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();

        GitHub gitHub = retrofit.create(GitHub.class);
        gitHub.getUsers("square", "retrofit")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Contributor>>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Contributor> contributors) {
                        data.addAll(contributors);
                    }
                });
    }
}
