package com.example.myapplication;

public class ContactModel {
    int img;
    String name;String number;
    ContactModel(int img,String name,String number){
        this.img=img;
        this.name=name;
        this.number=number;
    }
    ContactModel(String name,String number){
         this.name=name;
        this.number=number;
    }
};
