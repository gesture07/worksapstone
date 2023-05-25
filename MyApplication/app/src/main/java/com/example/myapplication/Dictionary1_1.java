package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;


public class Dictionary1_1 extends AppCompatActivity {

    public static ArrayList<data> dataList = new ArrayList<data>();

    ListView listView;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary1_1);

        searchData();

        setUpData();

        setUpList();

        setUpOnClickListener();


        button = findViewById(R.id.btnPhoto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        /*lv_list = findViewById(R.id.lv_list);*/
        /*sv_list = findViewById(R.id.sv_list);*/

        Button elebtn = (Button) findViewById(R.id.ele_btn);
        elebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Dictionary_ListView_Element1_2.class);
                startActivity(intent);
            }
        });


    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // Do something with the imageBitmap, such as display it in an ImageView
        }
    }

    private void searchData(){
        SearchView searchView = findViewById(R.id.sv_list);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            public boolean onQueryTextChange(String newText){
                ArrayList<data> filterData = new ArrayList<>();
                for(int i = 0; i < dataList.size(); i++){
                    data data = dataList.get(i);
                    if(data.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterData.add(data);
                    }
                }
                DataAdapter adapter = new DataAdapter(getApplicationContext(), 0, filterData);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }


    private void setUpData(){
        data elephant = new data("0", "elephant");
        dataList.add(elephant);

        data lion = new data("1", "lion");
        dataList.add(lion);

        data monkey = new data("3", "monkey");
        dataList.add(monkey);
    }


    private void setUpList(){
        listView = findViewById(R.id.lv_list);

        DataAdapter adapter = new DataAdapter(getApplicationContext(), 0, dataList);
        listView.setAdapter(adapter);
    }


    private void setUpOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I) {
                data selectdata = (data) listView.getItemAtPosition(position);
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id", selectdata.getId());
                startActivity(showDetail);
            }
        });
    }



}