package com.example.lenovo.mvptuorials.Login;

/**
 * Created by lenovo on 20/02/2018.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    public void moveToNextScreen();
    void setUsernameError();
    void setPasswordError();

}
