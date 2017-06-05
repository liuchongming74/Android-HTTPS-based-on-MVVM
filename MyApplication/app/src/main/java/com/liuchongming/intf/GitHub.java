package com.liuchongming.intf;

import com.liuchongming.beans.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by liuchongming on 2016/11/24.
 */

public interface GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> getUsers(@Path("owner") String owner, @Path("repo") String repo);
}
