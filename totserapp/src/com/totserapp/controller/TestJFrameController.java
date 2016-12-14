/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totserapp.controller;

import com.totserapp.view.JFrameView;
import com.totserapp.view.Test2JFrameView;

/**
 *
 * @author davidllanos22
 */
public class TestJFrameController extends JFrameController{
    int contador = 0;
    
    public TestJFrameController(JFrameView view) {
        super(view);
    }
    
    public void sumarContador(){
       contador++;
       ((Test2JFrameView)getView()).setCount(contador);
    }
    
}
