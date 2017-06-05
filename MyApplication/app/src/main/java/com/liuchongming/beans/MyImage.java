package com.liuchongming.beans;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.liuchongming.myapplication.BR;
import com.liuchongming.myapplication.R;

/**
 * Created by liuchongming on 2016/11/23.
 */

public class MyImage extends BaseObservable {
    private ObservableField<String> imageUrl = new ObservableField<>();
    private final int placeholderRes;

    public MyImage(Context context) {
        this.imageUrl.set("https://www.baidu.com/img/baidu_jgylogo3.gif");
        this.placeholderRes = R.mipmap.ic_launcher;
    }

    public int getPlaceholderRes() {
        return placeholderRes;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ObservableField<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
