package com.example.lenovo.mvptuorials.SignUp;

import com.example.lenovo.mvptuorials.callData.ApiClient;
import com.example.lenovo.mvptuorials.callData.ApiInterface;
import com.example.lenovo.mvptuorials.callData.GetCallback;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mina on 3/1/2018.
 */

public class SignUpModelImp implements SignUpModel {
    ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void requestSignUp(String mobile, String password, int familyID, final GetCallback.onSignUpFinish listener) {

        String data="{'Mobile':"+mobile+",'Password':'"+password+"','FamliyID':'"+ familyID +"'}";

        Call<String> call = apiInterface.signUpApi(data);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //  success=true;
                String s = response.body();
                try {
                    JSONObject object = new JSONObject(s);
                    listener.onSuccess(object.getString("Status"));
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
