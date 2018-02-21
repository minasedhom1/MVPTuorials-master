package com.example.lenovo.mvptuorials.Login;

import com.example.lenovo.mvptuorials.callData.ApiClient;
import com.example.lenovo.mvptuorials.callData.ApiInterface;
import com.example.lenovo.mvptuorials.callData.GetCallback;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 20/02/2018.
 */

public class LoginModelImpl implements LoginModel {
    ApiInterface apiInterface;

    @Override
    public void requestLogin(String userName, String password, final GetCallback.onLoginFinish listener) {
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
                try {
                JSONObject object=new JSONObject(s);

                    if(s.matches(object.toString())){
                         listener.onSuccess(new JSONObject(s).getString("Account ID"));
                   }
                   else{
                         listener.onFailure(object.getString("Status"));
                    }
              } catch (JSONException e) {
                e.printStackTrace();
               }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //  success=false;
                listener.onFailure(t.getMessage());
            }
        });
    }

}
