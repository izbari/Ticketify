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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignInActivity extends AppCompatActivity {

    private TextView loginEmail;
    private TextView loginPassword;
    private Button   loginButton;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth=FirebaseAuth.getInstance();

          loginEmail    = findViewById(R.id.inputEmail);
          loginPassword = findViewById(R.id.inputPassword);
          loginButton   = findViewById(R.id.loginButton);
          loadingBar = new ProgressDialog(this);

         loginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
             loginUser();
             }
         });

    }

    public void donthaveaccToCreate(View view)
    {
      Intent intent =new Intent(this, SignUpActivity.class);
      startActivity(intent);

    }

    public void forgotPassword(View view) {
        Intent intent =new Intent(SignInActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
    }
    public void loginUser()
    {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if(TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();
        if(TextUtils.isEmpty(password) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();
        else
        {
            loadingBar.setTitle("Login...");
            loadingBar.setMessage("Please wait...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(SignInActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    //startActivity(new Intent(SignInActivity.this,HomeActivity.class));
                    startActivity(new Intent(SignInActivity.this,MainActivity.class));
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignInActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    startActivity(new Intent(SignInActivity.this,SignInActivity.class));
                }
            });

        }
    }
}