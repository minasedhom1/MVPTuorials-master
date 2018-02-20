package com.example.lenovo.mvptuorials.callData;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mina on 1/10/2018.
 */

public interface ApiInterface {
    //@GET("/api/users?")
    @POST("Login")
    Call<String > reposForUser(@Body String data);
  //  Call<ResponseBody> getUser();
}
