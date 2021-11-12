package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void iniciarLogin(View view){
        Intent i = new Intent(this, MainActivityLogin.class);
        startActivity(i);
    }

    public void iniciarSelected(View view){
        Intent j = new Intent(this, ActivitySelectedCategory.class);
        startActivity(j);
    }
}