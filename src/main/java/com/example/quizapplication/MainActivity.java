package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startQuiz(View view) {
        name = findViewById(R.id.name);
        String nam= name.getText().toString();
        Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
        intent.putExtra("name",nam);
        startActivity(intent);
    }
}