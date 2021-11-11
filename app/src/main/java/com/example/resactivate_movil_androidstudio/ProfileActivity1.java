package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1);
    }
    public void iniciarProfile2(View view){
        Intent i = new Intent(this, ProfileActivity2.class);
        startActivity(i);
    }
}