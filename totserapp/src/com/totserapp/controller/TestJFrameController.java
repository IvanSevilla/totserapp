/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totserapp.controller;

import com.totserapp.view.View;
import com.totserapp.view.RegistreView;

/**
 *
 * @author davidllanos22
 */
public class TestJFrameController extends JFrameController{
    int contador = 0;
    
    public TestJFrameController(View view) {
        super(view);
    }
    
    public void sumarContador(){
       contador++;
       //((RegistreView)getView()).setCount(contador);
    }
    
}
