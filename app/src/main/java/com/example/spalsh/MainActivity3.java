package com.example.spalsh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText Name,Age,persons,Address,suggestions,id_proof;
    private MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        setListeners();
    }

    private void setListeners(){

        button.setOnClickListener(this);
    }

    private void init(){
        Name=(TextInputEditText)findViewById(R.id.username);
        Age=(TextInputEditText)findViewById(R.id.username1);
        Address=(TextInputEditText)findViewById(R.id.username2);
        persons=(TextInputEditText)findViewById(R.id.username3);
        id_proof=(TextInputEditText)findViewById(R.id.username4);
        suggestions=(TextInputEditText)findViewById(R.id.username5);
        button=(MaterialButton)findViewById(R.id.loginBtn);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                Mart mart = new Mart(Name.getText().toString().trim(), Age.getText().toString().trim(), Address.getText().toString().trim(), persons.getText().toString().trim(), id_proof.getText().toString().trim(), suggestions.getText().toString().trim());
                saveData(mart);
        }
    }

    private void saveData(Mart mart) {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("Details");
        myRef.push().setValue(mart);

    }
}
