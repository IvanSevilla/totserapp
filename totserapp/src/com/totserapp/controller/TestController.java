package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.view.OtherView;
import com.totserapp.view.View;

public class TestController extends Controller{
    
    public TestController(View view) {
        super(view);
    }
    
    public void comprobarHola(String entrada){
        if(entrada.equals("hola")){
            TotSeries.setView(new OtherView());
        }else{
           getView().show();
        }
    }
}
