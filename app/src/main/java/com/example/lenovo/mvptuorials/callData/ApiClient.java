package com.example.lenovo.mvptuorials.callData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mina on 1/10/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://197.45.12.35/ibn-ammey/api/AccountServices/Signin_Account/";//"https://reqres.in/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                  //  .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}