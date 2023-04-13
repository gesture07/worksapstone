package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Picture_Word_Result extends AppCompatActivity {

    private TextView resultText;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_word_result);

        resultText = findViewById(R.id.result_text_view);

        // correctAnswers와 totalQuestions 값을 받아옴
        Intent intent = getIntent();
        int correctAnswers = intent.getIntExtra("correctAnswers", 0);
        int totalQuestions = intent.getIntExtra("totalQuestions", 0);

        // 결과 텍스트를 설정
        String resultString = "You got " + correctAnswers + " out of " + totalQuestions + " correct!";
        resultText.setText(resultString);

        // 다시하기 버튼 클릭 리스너
        Button restartButton = findViewById(R.id.restart_button);
        restartButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(Picture_Word_Result.this, Picture_Word.class);
            finish();
            // Picture_Word 클래스로 이동
            startActivity(intent1);
        });

        // 오답 노트 버튼 클릭 리스너
        Button noteButton = findViewById(R.id.note_button);
        noteButton.setOnClickListener(v -> {
            Intent intent12 = new Intent(Picture_Word_Result.this, Training2_1.class);
            finish();
            startActivity(intent12);
        });
    }
}