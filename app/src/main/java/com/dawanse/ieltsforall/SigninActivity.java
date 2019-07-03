package com.dawanse.ieltsforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText _username;
    private EditText _password;
    private Button _signinBtn;
    private TextView _forgetPassBtn;
    private TextView _signupBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();

        _username = findViewById(R.id.signin_username_et);
        _password = findViewById(R.id.signin_password_et);
        _signinBtn = findViewById(R.id.signin_signin_btn);
        _signupBtn = findViewById(R.id.signin_signup_tv);
        _forgetPassBtn = findViewById(R.id.signin_forget_pass_tv);

        _signinBtn.setOnClickListener(this);
        _signupBtn.setOnClickListener(this);
        _forgetPassBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_signin_btn:
//                userSignIn();
            case R.id.signin_forget_pass_tv:
            case R.id.signin_signup_tv:
//                startActivity(new Intent(this, SignUpActivity.class));
        }
    }

    private void userSignIn() {
        String username = _username.getText().toString().trim();
        String password = _password.getText().toString().trim();

        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Username or Password is missing!!!", Toast.LENGTH_SHORT).show();
        }

        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                            finish();
                        } else {
                            //
                            Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
