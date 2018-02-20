package com.example.lenovo.mvptuorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter;
    private ProgressBar progress;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress= (ProgressBar) findViewById(R.id.progress_bar);
        userNameEditText= (EditText) findViewById(R.id.username_et);
        passwordEditText= (EditText) findViewById(R.id.password);
        loginButton= (Button) findViewById(R.id.signin_btn);

        presenter = new LoginPresenter(this); //pass

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
}
