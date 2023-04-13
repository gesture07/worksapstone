package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Choose2_1_2 extends AppCompatActivity {



    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose2_1_2);

        //adapter생성
        ListViewAdapter adapter = new ListViewAdapter();

        //리스트뷰 참조 및 adapter달기
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        adapter.addItem("사과", "빨간색");
        adapter.addItem("딸기", "빨간색");
        adapter.addItem("바나나", "노란색");
        adapter.addItem("수박", "초록색");
        //adapter.addItem("사과", "빨간색");
        //adapter.addItem("사과", "빨간색");




        //listView binding
        //listView = findViewById(R.id.listView);

        //데이터를 담을 list
        //List<String> itemList = new ArrayList<String>();

        //데이터 추가
        //itemList.add("사과");
    }


    //int itemList;
    //adapter 생성
   // ArrayAdapter<String> adapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, itemList);

    //listView에 adapter연결
    // listView.setAdapter(adapter);

}
