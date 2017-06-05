package com.liuchongming.intf;

import com.liuchongming.beans.UserBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by liuchongming on 2016/12/5.
 * Project Name: MyApplication
 * Package Mame: com.liuchongming.beans
 */

public interface IUser {
    @GET("/SSLServer/userService/user/{phone}")
    Observable<UserBean> getUser(@Path("phone") String phone);

    @POST("/AdministrativeApproval/api/userService/login/{username}/{password}")
    Observable<UserBean> login(@Path("username") String username, @Path("password") String password);
}
