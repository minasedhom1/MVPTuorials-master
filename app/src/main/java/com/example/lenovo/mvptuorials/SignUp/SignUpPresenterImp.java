package com.example.lenovo.mvptuorials.SignUp;

import com.example.lenovo.mvptuorials.callData.GetCallback;

/**
 * Created by Mina on 3/1/2018.
 */

public class SignUpPresenterImp implements SignUpPresenter,GetCallback.onSignUpFinish {

    SignUpModelImp signUpModelImp;
    SignUpView signUpView;

    public SignUpPresenterImp(SignUpView signUpView){
        signUpModelImp= new SignUpModelImp();
        this.signUpView=signUpView;
    }



    @Override
    public boolean validatePhone(String phone) {
        if(phone.length()!=11){
            signUpView.setUsernameError("Phone must be 11 digits.");
            signUpView.setPasswordError(null);
            signUpView.setRepeatPasswordError(null);
            return false;
        }
        else{
            signUpView.setUsernameError(null);
            return true;}
    }

    @Override
    public boolean validatePass(String pass, String repeat) {
        if(pass.length()<5){
            signUpView.setPasswordError("Password must be 5 digits.");
            signUpView.setRepeatPasswordError(null);
            return false;
        }
        else if(!(repeat.equals(pass))){
            signUpView.setRepeatPasswordError("The repeat must match password.");
            signUpView.setPasswordError(null);
            return false;
        }
        else{
            signUpView.setPasswordError(null);
            signUpView.setRepeatPasswordError(null);
            return true;}
    }

    @Override
    public void onSignUpClicked(String phone, String password,String repeat,int family) {
        signUpView.showProgress();
        if(validatePhone(phone)&& validatePass(password,repeat)) {
            requestSignUpFromModel(phone,password,family);
        }
        else signUpView.hideProgress();


    }

    @Override
    public void requestSignUpFromModel(String phone, String password,int family) {
        signUpModelImp.requestSignUp(phone,password,family,this);
    }

    @Override
    public void onSuccess(String s) {
        signUpView.hideProgress();
        signUpView.showMessage(s);
    }

    @Override
    public void onFailure(String s) {
        signUpView.hideProgress();
        signUpView.showMessage(s);

    }
}
