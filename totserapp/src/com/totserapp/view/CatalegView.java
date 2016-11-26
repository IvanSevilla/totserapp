package com.totserapp.view;

import com.totserapp.controller.CatalegController;
import com.totserapp.util.Consola;

public class CatalegView extends View{
    private CatalegController controller = new CatalegController(this);
    
    @Override
    public void show() {
        Consola.escriu("Cataleg");
    }
}
