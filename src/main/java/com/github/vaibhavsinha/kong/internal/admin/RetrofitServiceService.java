package com.github.vaibhavsinha.kong.internal.admin;

import com.github.vaibhavsinha.kong.model.admin.service.Service;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitServiceService {

    @POST("services/")
    Call<Service> addService(@Body Service request);
    @DELETE("services/{nameOrId}")
    Call<Void> deleteService(@Path("nameOrId") String nameOrId);
}