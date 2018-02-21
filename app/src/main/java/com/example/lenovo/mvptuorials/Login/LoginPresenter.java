package com.example.lenovo.mvptuorials.Login;

/**
 * Created by Mina on 2/21/2018.
 */

public interface LoginPresenter {
    public void onLoginClicked(String userName,String password);
    public boolean isValidFormat(String userName, String password);
    public void requestLoginFromModel(String userName, String password);
}
