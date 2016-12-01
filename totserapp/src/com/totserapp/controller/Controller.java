package com.totserapp.controller;

import com.totserapp.view.View;

/**
 * Classe controlador base que serà pare de tota la resta de controladors.
 * La vista fa peticions al controlador i aquest retorna sempre un String 
 * amb les dades demanades o amb un missatge d'error. També canvia de vista 
 * si és necessari.
 */

public class Controller {
    private View view;
    
    public Controller(View view){
        this.view = view;
    }
    
    public View getView(){
        return view;
    }
}
