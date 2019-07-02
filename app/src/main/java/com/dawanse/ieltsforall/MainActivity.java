package com.dawanse.ieltsforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView _signinBtn;
    private LinearLayout _facebookBtn;
    private LinearLayout _signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _signinBtn = findViewById(R.id.login_signin_text);
        _facebookBtn = findViewById(R.id.login_fb_layout);
        _signupBtn = findViewById(R.id.login_create_account_layout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_signin_text:
                startActivity(new Intent(this, SigninActivity.class));
            case R.id.login_fb_layout:
                startActivity(new Intent(this, DashboardActivity.class));
            case R.id.login_create_account_layout:
                startActivity(new Intent(this, SignUpActivity.class));
        }
    }
}
