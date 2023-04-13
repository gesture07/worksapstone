package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz3_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3_1);

        //퀴즈 버튼 클릭시 액티비티 전환
        Button quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), QuizPopup3_1_1.class);
                startActivity(intent);
            }
        });
    }
}
