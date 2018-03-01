package com.example.lenovo.mvptuorials.SignUp;

import com.example.lenovo.mvptuorials.callData.GetCallback;

/**
 * Created by Mina on 3/1/2018.
 */

public interface SignUpModel {
    void requestSignUp(String mobile,String password,int familyID,GetCallback.onSignUpFinish listener);

}
