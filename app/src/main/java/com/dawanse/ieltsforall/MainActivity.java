package com.dawanse.ieltsforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView _signinBtn;
    private LinearLayout _facebookBtn;
    private LinearLayout _signupBtn;

    //facebook
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //facebook
        FacebookSdk.sdkInitialize(getApplicationContext());

        _signinBtn = findViewById(R.id.login_signin_text);
        _facebookBtn = findViewById(R.id.login_fb_layout);
        _signupBtn = findViewById(R.id.login_create_account_layout);

        _signinBtn.setOnClickListener(this);
        _facebookBtn.setOnClickListener(this);

        _signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailSignIn();
            }
        });
        _signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignUp();
            }
        });
        _facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fbSignIn();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_signin_text:
//                startActivity(new Intent(this, SigninActivity.class));
            case R.id.login_fb_layout:
//                startActivity(new Intent(this, DashboardActivity.class));
//                finish();
            case R.id.login_create_account_layout:
//                startActivity(new Intent(this, SignUpActivity.class));
        }
    }

    private void emailSignIn() {
        startActivity(new Intent(this, SigninActivity.class));
    }

    private void fbSignIn() {
        callbackManager = CallbackManager.Factory.create();
//        LoginManager.getInstance().
    }

    private void userSignUp() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

}
