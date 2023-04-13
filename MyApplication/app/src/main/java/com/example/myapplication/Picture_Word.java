package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.CountryItem;
import com.example.myapplication.Database;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Picture_Word extends AppCompatActivity {
    Button b_answer1, b_answer2, b_answer3, b_answer4;
    ImageView iv_flag;
    List<CountryItem> list;
    Random r;
    int turn = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_word);
        r = new Random();
        iv_flag = findViewById(R.id.imageview);
        b_answer1 = findViewById(R.id.b_answer1);
        b_answer2 = findViewById(R.id.b_answer2);
        b_answer3 = findViewById(R.id.b_answer3);
        b_answer4 = findViewById(R.id.b_answer4);
        list = new ArrayList<>();
        // 국기와 국명 넣기
        for (int i = 0; i < new Database().flags_answers.length; i++) {
            list.add(new CountryItem(new Database().flags_answers[i], new Database().flags[i]));
        }
        // 랜덤
        Collections.shuffle(list);
        newQuestion(turn);
        b_answer1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //정답 체크
                if (b_answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(Picture_Word.this, "Correct!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(Picture_Word.this, "You finished the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(Picture_Word.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(Picture_Word.this, "You lost the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 정답 체크
                if (b_answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(Picture_Word.this, "Correct!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);

                    } else {
                        Toast.makeText(Picture_Word.this, "wrong!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //정답체크
                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn -1).getName())){
                    Toast.makeText(Picture_Word.this, "correct!", Toast.LENGTH_SHORT).show();

                    //마지막 문제 체크
                    if( turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    } else{
                        Toast.makeText(Picture_Word.this, "youfinished the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else{
                    Toast.makeText(Picture_Word.this, "wrong!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    } else{
                        Toast.makeText(Picture_Word.this, "you lost the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //정답체크
                if (b_answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(Picture_Word.this, "correct!", Toast.LENGTH_SHORT).show();

                    //마자막 문제 체크
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(Picture_Word.this, "you finished the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(Picture_Word.this, "wrong!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(Picture_Word.this, "you lost the game!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
    private void newQuestion(int number){
        //국기 이미지를 스크린에 세팅한다.
        iv_flag.setImageResource(list.get(number - 1).getImage());
        int corret_answer = r.nextInt(4) + 1;

        int firstButton = number -1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch  (corret_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                } while(forthButton == firstButton ||forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());

                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                } while(forthButton == firstButton ||forthButton == secondButton || forthButton == thirdButton);

                b_answer1.setText(list.get(firstButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());

                break;

            case 3:
                b_answer3.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                } while(forthButton == firstButton ||forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(firstButton).getName());
                b_answer4.setText(list.get(forthButton).getName());

                break;

            case 4:
                b_answer4.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                } while(forthButton == firstButton ||forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(firstButton).getName());

                break;
        }

    }
}
