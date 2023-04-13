package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.1 사전 클릭 시 액티비티 전환
        Button dictionary1_1 = (Button) findViewById(R.id.dictionary1_1);
        dictionary1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Dictionary1_1.class);
                startActivity(intent);
            }
        });

        //2.1 교육,오답 클릭 시 액티비티 전환
        Button training2_1 = (Button) findViewById(R.id.training2_1);
        training2_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Training2_1.class);
                startActivity(intent);
            }
        });

        //3.1 퀴즈 클릭 시 액티비티 전환
        Button quiz3_1 = (Button) findViewById(R.id.quizpopup3_1_1);
        quiz3_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QuizPopup3_1_1.class);
                startActivity(intent);
            }
        });

        /*//2_1_2 리스트 뷰 어뎁터 클래스
        @SuppressLint({"WrongViewCast", "MissingInflatedId", "LocalSuppress"}) ListView listView = findViewById(R.id.listView);
        SingerAdapter adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("사과"));
        listView.setAdapter(adapter);

    }
    class SingerAdapter extends BaseAdapter{
        //데이터가 들어가 있지 않고, 어떻게 담으지만 정의해둠.
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public int getCount(){
            return items.size();
        }
        public void addItem(SingerItem item){
            items.add(item);
        }
        public Object getItem(int position){
            return items.get(position);
        }
        public long getItemId(int position){
            return position;
        }
;

        //어댑터가 데이터를 관리하고 뷰도 만듬
        public View getView(int position,View convertView, ViewGroup parent){
            SingerItemView singerItemView = null;
            //코드를 재사용할 수 있도록
            if(convertView ==null){
                singerItemView = new SingerItemView(getApplicationContext());

            }
        }*/

    }


}