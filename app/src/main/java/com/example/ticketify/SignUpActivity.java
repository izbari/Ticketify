package com.example.ticketify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private TextView signupEmail;
    private TextView signUpPassword;
    private TextView signUpTextButton;
    private TextView signUpPasswordAgain;
    private Button SignUpButton;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth= FirebaseAuth.getInstance();

        signupEmail         = findViewById(R.id.signupEmailInput);
        signUpPassword      = findViewById(R.id.signupPasswordInput);
        signUpTextButton    = findViewById(R.id.editible);
        signUpPasswordAgain = findViewById(R.id.signupPasswordAgainInput);
        SignUpButton        = findViewById(R.id.signupbutton);
        loadingBar          = new ProgressDialog(this);

        signUpTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLoginActivity();
            }
        });

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });


    }
    public void RegisterUser()
    {
        String email = signupEmail.getText().toString();
        String password = signUpPassword.getText().toString();
        String confirmPassword = signUpPasswordAgain.getText().toString();

        if(TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();
        if(TextUtils.isEmpty(password) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();
        if (!password.equals((confirmPassword)))
            Toast.makeText(getBaseContext(), "ERROR:Password and Confirm Password didn't match!", Toast.LENGTH_SHORT).show();

        else
        {
            loadingBar.setTitle("Creating new account...");
            loadingBar.setMessage("Please wait, we are creating new account for you...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()) {
                        Toast.makeText(SignUpActivity.this, "Account created Successfully!", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                        navigateToLoginActivity();
                    }
                    else{
                        Toast.makeText(SignUpActivity.this, "ERROR:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });

        }
    }

    public void navigateToLoginActivity(){
        Intent intent =new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

}