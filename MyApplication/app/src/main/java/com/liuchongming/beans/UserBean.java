package com.liuchongming.beans;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liuchongming.myapplication.BR;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuchongming on 2016/11/22.
 * 如果要能被View绑定，需要在get方法上添加@Bindable标注
 */

public class UserBean extends BaseObservable implements Serializable {
    private String name;
    private String password;
    private String phone;
    private Date date;

    private final static String TAG = "RXJAVA LEARNING";

    public UserBean() {
        this.setName("");
        this.setPassword("");
        this.setPhone("");
    }

    /**
     * name与view进行双向绑定
     *
     * @return
     */
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    /**
     * phone与view进行双向绑定
     *
     * @return
     */
    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    /**
     * password与view进行双向绑定
     *
     * @return
     */
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
