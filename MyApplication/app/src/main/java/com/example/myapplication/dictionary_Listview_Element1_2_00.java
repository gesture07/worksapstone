package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;

public class dictionary_Listview_Element1_2_00 extends AppCompatActivity {
    private final int GALLERY_CODE = 10;
    ImageView photo;
    private FirebaseStorage storage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ditionary_listview_element1_2_00);
        findViewById(R.id.fbimage).setOnClickListener(onClickListener);
        photo = (ImageView)findViewById(R.id.fbimage);
        storage = FirebaseStorage.getInstance();
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fbimage:
                    loadAlbum();
                    break;
            }
        }
    };

    private void loadAlbum(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, GALLERY_CODE);
    }



}
