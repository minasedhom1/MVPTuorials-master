package com.example.lenovo.mvptuorials.callData;

/**
 * Created by Mina on 2/20/2018.
 */

public abstract class GetCallback {
    public interface login{
        void onSuccess(String s);
        void onFailure(String s);
    }
}
