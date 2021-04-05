package com.example.ticketify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {
    private TextView resetInputEmail;
    private Button resetSendEmail;
    private FirebaseAuth mAuht ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        resetInputEmail = findViewById(R.id.resetInputEmail);
        resetSendEmail  = findViewById(R.id.sendEmailButton);
        mAuht= FirebaseAuth.getInstance();

         resetSendEmail.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String userEmail = resetInputEmail.getText().toString();

             if(TextUtils.isEmpty(userEmail)){
                 Toast.makeText(ResetPasswordActivity.this, "Please  write your valid email!", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 mAuht.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {
                         if(task.isSuccessful())
                         {
                             Toast.makeText(ResetPasswordActivity.this, "Reset link sent check your email!", Toast.LENGTH_SHORT).show();
                             startActivity(new Intent(ResetPasswordActivity.this,SignInActivity.class));
                         }
                         else
                         {
                             Toast.makeText(ResetPasswordActivity.this,"ERROR:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         }
                     }
                 });
             }
         }
     });
}


    }

