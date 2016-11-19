package com.totserapp.controller;

import com.totserapp.view.View;

public class Controller {
    private View view;
    
    public Controller(View view){
        this.view = view;
    }
    
    public View getView(){
        return view;
    }
}
