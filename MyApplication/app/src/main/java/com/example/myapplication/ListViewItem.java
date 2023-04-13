package com.example.myapplication;

public class ListViewItem {

    private static String contentStr;
    private static String titleStr;



    public static String getContent() {
        return contentStr;
    }
    public static String getTitle(){
        return titleStr;
    }


    public void setTitle(String title) {
        titleStr = title;
    }

    public void setContent(String content) {
        contentStr = content;
    }
}
