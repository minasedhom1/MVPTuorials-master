package com.example.lenovo.mvptuorials.Login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvptuorials.HomeActivity;
import com.example.lenovo.mvptuorials.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenterImpl presenter;
    private ProgressBar progress;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextInputLayout name_layout,password_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress= (ProgressBar) findViewById(R.id.progress_bar);
        userNameEditText= (EditText) findViewById(R.id.username_et);
        passwordEditText= (EditText) findViewById(R.id.password);
        loginButton= (Button) findViewById(R.id.signin_btn);
        name_layout= (TextInputLayout) findViewById(R.id.input_layout_name);
        password_layout= (TextInputLayout) findViewById(R.id.input_layout_password);

        presenter = new LoginPresenterImpl(this); //pass

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                presenter.onLoginClicked(userName,password);
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
    public void showError(String error) {
        Toast.makeText(LoginActivity.this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToNextScreen() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }

    @Override
    public void setUsernameError( ) {
        name_layout.setError("username Error");
    }

    @Override
    public void setPasswordError() {
        name_layout.setError("password error");

    }
}
