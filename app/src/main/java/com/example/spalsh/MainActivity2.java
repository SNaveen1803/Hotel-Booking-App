package com.example.spalsh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button move,move1,move2,move3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        move=findViewById(R.id.hotelBookButton);
        move1=findViewById(R.id.hotelBookButton);
        move2=findViewById(R.id.hotelBookButton);
        move3=findViewById(R.id.hotelBookButton);
        move.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });
            move1.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                                             startActivity(i);
                                             finish();
                                         }
                                     });
                move2.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                                                 startActivity(i);
                                                 finish();
                                             }
                                         });
                            move3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i=new Intent(MainActivity2.this, MainActivity3.class);
                            startActivity(i);
                            finish();
                        }
        });
    }
}