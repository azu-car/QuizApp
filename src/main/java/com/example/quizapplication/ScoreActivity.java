package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView nm,correct,incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle b=getIntent().getExtras();
        String name = b.getString("uname");
        int correc = b.getInt("correct");
        int wrong = b.getInt("wrong");
        //System.out.println(correc+"      "+wrong+"    "+name);

        nm= findViewById(R.id.view);
        correct = findViewById(R.id.correc);
        incorrect =findViewById(R.id.wron);

        nm.setText(name +" Your Score Is");
        correct.setText("Correct : "+correc);
        incorrect.setText("Incorrect : "+wrong);


    }

    public void restart(View view) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);

        nm.setText(" ");
        correct.setText(" ");
        incorrect.setText(" ");

        startActivity(i);
    }
}