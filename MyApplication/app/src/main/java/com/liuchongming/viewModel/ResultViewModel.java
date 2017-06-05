package com.liuchongming.viewModel;


import android.content.Context;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.base.ViewModel;
import com.liuchongming.beans.MyImage;
import com.liuchongming.beans.UserBean;

/**
 * Created by liuchongming on 2016/11/23.
 */

public class ResultViewModel implements ViewModel {
    private Context context;
    private UserBean user;
    private MyImage img;
    public final ObservableField<String> imageUrl = new ObservableField<>();

    public ResultViewModel(Context context, UserBean user) {
        this.context = context;
        this.user = user;
        this.imageUrl.set("http://img.wdjimg.com/mms/icon/v1/e/0e/0f39a272ea6001e77b70a98ad5dcc0ee_256_256.png");
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }
}
