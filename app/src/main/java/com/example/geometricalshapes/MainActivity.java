package com.example.geometricalshapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.geometricalshapes.Views.CustomView;

public class MainActivity extends AppCompatActivity {
CustomView custView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custView=findViewById(R.id.custview);
    }
    public void swap(View view){
        custView.swapColor();
    }
}