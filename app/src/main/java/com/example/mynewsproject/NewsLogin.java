package com.example.mynewsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.reactivex.annotations.NonNull;

public class NewsLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editTextLogin;
    private EditText editTextPassword;
    private TextView textView_registr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_login);
        mAuth=FirebaseAuth.getInstance();
        editTextLogin=findViewById(R.id.editText_login);
        editTextPassword=findViewById(R.id.editText_password);
        textView_registr=findViewById(R.id.textView_registr);
        textView_registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsLogin.this,Registration.class);
                startActivity(intent);
            }
        });
    }

    public void onClickLogin(View view) {
        String email = editTextLogin.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        if (email.isEmpty()||password.isEmpty()){
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(NewsLogin.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(NewsLogin.this, "Ошибка "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}