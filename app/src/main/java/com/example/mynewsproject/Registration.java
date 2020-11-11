package com.example.mynewsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynewsproject.Pojo.Kino.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Registration extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextAge;
    private EditText editTextPol;
    private FirebaseFirestore db;
    private String firstName;
    private String lastName;
    private int age;
    private String pol;
    private User user1;
    private List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin_password);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextPol = findViewById(R.id.editTextPol);
        db = FirebaseFirestore.getInstance();

    }

    public void onClickSaveName(View view) {
        firstName = String.valueOf(editTextName.getText());
        lastName = String.valueOf(editTextLastName.getText());
        pol = String.valueOf(editTextPol.getText());
        age = Integer.parseInt(String.valueOf(editTextAge.getText()));
        user = new ArrayList<>();
        user1 = new User(firstName,lastName,age,pol);
        user.add(user1);
        db.collection("users")
                .add(user1)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Registration.this, "Пользователь добавлен", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this, "Ошибка при добавлении", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}