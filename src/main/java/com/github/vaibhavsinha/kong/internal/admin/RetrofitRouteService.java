package com.github.vaibhavsinha.kong.internal.admin;

import java.util.List;

import com.github.vaibhavsinha.kong.model.admin.route.Route;
import com.github.vaibhavsinha.kong.model.common.CommonList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitRouteService {
    @POST("routes/")
    Call<Route> addRoute(@Body Route route);
    @DELETE("routes/{id}")
    Call<Void> deleteRoute(@Path("id") String id);
    @GET("services/{id}/routes")
    Call<CommonList<Route>> listRoutesByService(@Path("id") String id);
}