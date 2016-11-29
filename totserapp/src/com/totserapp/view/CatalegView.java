package com.totserapp.view;

import com.totserapp.controller.CatalegController;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class CatalegView extends View{
    private CatalegController controller = new CatalegController(this);
    
    @Override
    public void show() {
        Consola.escriu("TOT SERIES - Catàleg");
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        String result = controller.visualitzarCataleg();
        
        Consola.escriu("\n" + result);
        
        Consola.escriu("Selecciona una serie (1-10) o torna al menu anterior (0): ");
        
        int i = Consola.llegeixInt();
        
        Consola.escriu("\n");

        result = controller.opcioSeleccionada(i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu("\nOpció incorrecte.");
            show();
        }
        
    }
}
