package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {
    TextView corr,wro,que;
    RadioButton r1,r2,r3,r4;
    int flag=0;
    public static int correct=0,wrong=0;
    String name;

    String questions[] = {
            "What is Capital of India ?",
            "What is Capital of japan ?",
            "Which method can be defined only once in a program?",
            "Compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to"
    };
    String answers[] = {"New Delhi","Tokyo","main","equals()","int"};

    String opt[] = {
            "New Delhi","Mumbai","Chennai","Kolkata",
            "Mumbai","Tokyo","Hong Kong","Beijing",
            "finalize","main","static","private",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        corr = findViewById(R.id.right);
        wro = findViewById(R.id.wrong);
        que = findViewById(R.id.que);

        r1=findViewById(R.id.opt1);
        r2=findViewById(R.id.opt2);
        r3=findViewById(R.id.opt3);
        r4=findViewById(R.id.opt4);

        que.setText(questions[flag]);
        r1.setText(opt[flag *4]);
        r2.setText(opt[flag *4 +1]);
        r3.setText(opt[flag *4 +2]);
        r4.setText(opt[flag *4 +3]);

    }


    public void checkAns(View view) {

        RadioGroup rg = (RadioGroup) findViewById(R.id.grp);
        final String selected =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();
        rg.clearCheck();
        if(selected.equals(answers[flag])){
            flag++;
            correct++;
        }
        else{
            flag++;
            wrong++;
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                updateQuestion();
            }
        }, 1200);
    }
    void updateQuestion() {

        if(flag!=5){
            corr.setText(""+correct);
            wro.setText(""+wrong);
            que.setText(questions[flag]);
            r1.setText(opt[flag *4]);
            r2.setText(opt[flag *4 +1]);
            r3.setText(opt[flag *4 +2]);
            r4.setText(opt[flag *4 +3]);
        }
        else{
            Intent i = new Intent(getApplicationContext(),ScoreActivity.class);
            Bundle bb = new Bundle();
            bb.putInt("correct",correct);
            bb.putInt("wrong",wrong);

            Intent prev = getIntent();
            String name = prev.getStringExtra("name");
            bb.putString("uname",name);
            i.putExtras(bb);
            startActivity(i);
            correct=0;
            wrong=0;
        }
    }
}