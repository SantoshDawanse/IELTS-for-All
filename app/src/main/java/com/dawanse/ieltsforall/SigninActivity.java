package com.dawanse.ieltsforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText _username;
    private EditText _password;
    private Button _signinBtn;
    private TextView _forgetPassBtn;
    private TextView _signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        _username = findViewById(R.id.signin_username_et);
        _password = findViewById(R.id.signin_password_et);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_signin_btn:
                startActivity(new Intent(this, DashboardActivity.class));
            case R.id.signin_forget_pass_tv:
            case R.id.signin_signup_tv:
                startActivity(new Intent(this, SignUpActivity.class));
        }
    }

    private void getUserData() {
        String username = _username.getText().toString().trim();
        String password = _password.getText().toString().trim();
    }
}
