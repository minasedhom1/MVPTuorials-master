package com.example.lenovo.mvptuorials.SignUp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvptuorials.Login.LoginActivity;
import com.example.lenovo.mvptuorials.Login.LoginPresenterImpl;
import com.example.lenovo.mvptuorials.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    private SignUpPresenterImp presenter;
    private ProgressBar progress;
    private EditText userNameEditText;
    private EditText passwordEditText,repeatPasswordEditText;
    private Button signUpButton;
    private TextInputLayout name_layout,password_layout,repeat_password_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progress= (ProgressBar) findViewById(R.id.progress_bar);
        userNameEditText= (EditText) findViewById(R.id.username_et);
        passwordEditText= (EditText) findViewById(R.id.password);
        repeatPasswordEditText= (EditText) findViewById(R.id.repeat_password);
        signUpButton= (Button) findViewById(R.id.signup_btn);
        name_layout= (TextInputLayout) findViewById(R.id.input_layout_name);
        password_layout= (TextInputLayout) findViewById(R.id.input_layout_password);
        repeat_password_layout= (TextInputLayout) findViewById(R.id.input_layout_repeat_password);

        presenter=new SignUpPresenterImp(this);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=userNameEditText.getText().toString();
                String pass=passwordEditText.getText().toString();
                String repeat=repeatPasswordEditText.getText().toString();
                presenter.onSignUpClicked(phone,pass,repeat,1);
            }
        });
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToNextScreen() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }

    @Override
    public void setUsernameError(String e) {
        name_layout.setError(e);
    }

    @Override
    public void setPasswordError(String e) {
        password_layout.setError(e);
    }

    @Override
    public void setRepeatPasswordError(String e) {
        repeat_password_layout.setError(e);

    }
}
