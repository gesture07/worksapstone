package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private TextView titleTextView;
    private TextView contentTextView;

    //adapter에 추가된 데이터를 저장하기 위한 arraylist
    private ArrayList<ListViewItem> listViewitemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }

    //adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount() {
        return listViewitemList.size();
    }

    //지정한 위치에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return listViewitemList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    //position 에 위치한 데이터를 화면에 출려하는데 사용될 view를 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //listview_item layout을 infloat하여 converview 참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        //화면에 표시될 view(layout이inflate된)으로부터 위젯에 대한 참조 획득
        titleTextView =(TextView) convertView.findViewById((R.id.title));
        contentTextView = (TextView)  convertView.findViewById(R.id.content);
        ListViewItem listviewItem = listViewitemList.get(position);

        //아이템 내 각 위젯에 데이터 변경
        titleTextView.setText(ListViewItem.getTitle());
        contentTextView.setText(ListViewItem.getContent());

        return convertView;
    }
    public void addItem(String title, String content) {
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setContent(content);

        listViewitemList.add(item);
    }


}
