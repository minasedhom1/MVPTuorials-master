package com.example.lenovo.mvptuorials.Login;

import com.example.lenovo.mvptuorials.callData.GetCallback;

/**
 * Created by Mina on 2/21/2018.
 */

public interface LoginModel {
     void requestLogin( String userName, String password,final GetCallback.onLoginFinish listener);
}
