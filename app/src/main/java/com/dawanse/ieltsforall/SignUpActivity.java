package com.dawanse.ieltsforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dawanse.ieltsforall.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText _fullname, _email, _phone, _password, _confirmPass;
    private Button _signUpBtn;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        _fullname = findViewById(R.id.signup_fullname_et);
        _email = findViewById(R.id.signup_email_et);
        _phone = findViewById(R.id.signup_phone_et);
        _password = findViewById(R.id.signup_password_et);
        _confirmPass = findViewById(R.id.signup_confirm_password_et);
        _signUpBtn = findViewById(R.id.signup_signup_btn);

        _signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_signup_btn:
                createUser();
        }
    }

    private void createUser() {
        final String fullname = _fullname.getText().toString().trim();
        final String email = _email.getText().toString().trim();
        final String phone = _phone.getText().toString().trim();
        String password = _password.getText().toString().trim();
        String confirmPassword = _confirmPass.getText().toString().trim();

        if (fullname.isEmpty()) {
            _fullname.setError("Enter your full name");
            _fullname.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            _email.setError("Enter your email");
            _email.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            _phone.setError("Enter your phone number");
            _phone.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            _password.setError("Enter your password");
            _password.requestFocus();
            return;
        }

        if (confirmPassword.isEmpty()) {
            _confirmPass.setError("Re-enter your password");
            _confirmPass.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            _confirmPass.setError("Re-enter your password");
            _confirmPass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //write user info in database
                            User user = new User(fullname, email, phone);
                            databaseReference.child("users")
                                    .child(FirebaseAuth.getInstance().getUid())
                                    .setValue(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(getApplicationContext(), "User registration successful", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), SigninActivity.class));
                                            finish();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(), "User details registration failed", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                            startActivity(new Intent());
                        } else {
                            //
                            Toast.makeText(getApplicationContext(), "Sorry, user cannot be created, try again!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
