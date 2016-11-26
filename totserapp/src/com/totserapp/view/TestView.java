
package com.totserapp.view;

import com.totserapp.controller.TestController;
import com.totserapp.util.Consola;

public class TestView extends View{
    private TestController controlador = new TestController(this);
    
    @Override
    public void show(){
        //TestClient client = TotSeries.getDataManager().getClients().get(0);
        Consola.escriu("TOT SERIES\n");
        
        //Consola.escriu(client.toString());
        
        Consola.escriu("\n\nIntroduce 'hola' para cambiar de vista: ");
        
        String in = Consola.llegeixString();
        
        controlador.comprobarHola(in);
        
    }
    
}
