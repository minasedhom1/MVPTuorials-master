package com.example.lenovo.mvptuorials;

import com.example.lenovo.mvptuorials.callData.ApiClient;
import com.example.lenovo.mvptuorials.callData.ApiInterface;
import com.example.lenovo.mvptuorials.callData.GetCallback;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 20/02/2018.
 */

public class LoginModel {
    ApiInterface apiInterface;

    public void requestLogin(final GetCallback.login login, String userName, String password){
            // for sake of simplicity, this method returns boolean after
            // receiving a response from server

          String data="{'Mobile':"+userName+",'Password':'"+password+"'}";
          apiInterface= ApiClient.getClient().create(ApiInterface.class);
          Call<String> call = apiInterface.reposForUser(data);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                  //  success=true;
                              String s= response.body();
                              s.toCharArray();
                              login.onSuccess(s);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                  //  success=false;
                    login.onFailure(t.getMessage());

                }
            });
       // return success;

    }

}
