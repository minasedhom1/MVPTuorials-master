package com.example.lenovo.mvptuorials.Login;

import android.content.Context;
import android.widget.Toast;

import com.example.lenovo.mvptuorials.callData.GetCallback;

/**
 * Created by lenovo on 20/02/2018.
 */

public class LoginPresenterImpl implements LoginPresenter,GetCallback.onLoginFinish  {

    private LoginView loginView;
    private LoginModelImpl loginModel;

    public LoginPresenterImpl(LoginView loginView){ //take an object of a class implements the model view
        this.loginView=loginView;
        this.loginModel=new LoginModelImpl();
    }

    @Override
    public void onLoginClicked(String userName,String password){
        if(isValidFormat(userName,password)){
            requestLoginFromModel(userName,password);
        }else{
            loginView.showError("invalid data");
        }
    }

    @Override
     public boolean isValidFormat(String userName, String password){
        if(userName.isEmpty()){
            loginView.setUsernameError();
            return false;
        }
        else if(password.isEmpty()){
            loginView.setPasswordError();
            return false;
        }
        else return true;
    }

    @Override
     public void requestLoginFromModel(String userName, String password){
        loginView.showProgress();
        loginModel.requestLogin(userName,password,this);
    }


    @Override
    public void onSuccess(String s) {
        loginView.hideProgress();
        loginView.showError("Login success. your id is: " + s);
        loginView.moveToNextScreen();
    }

    @Override
    public void onFailure(String s) {
        loginView.hideProgress();
        loginView.showError(s);
    }
}
