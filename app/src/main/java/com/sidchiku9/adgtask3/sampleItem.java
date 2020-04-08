package com.sidchiku9.adgtask3;

public class sampleItem {
    private String mText1;
    private String mText2;

     public sampleItem(String text1,String text2){
         mText1  = text1;
         mText2 = text2;
     }

     public String getHeading(){
         return mText1;
     }
     public String getContent(){
         return mText2;
     }
}
