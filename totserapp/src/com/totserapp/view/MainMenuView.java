package com.totserapp.view;

import com.totserapp.controller.MainMenuController;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class MainMenuView extends View{
    MainMenuController controller = new MainMenuController(this);
    
    @Override
    public void show() {
        Consola.escriu(Constants.MISSATGE_NOM_APLICACIO);
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        Consola.escriu("\n" + Constants.MISSATGE_REGISTRE);
        Consola.escriu("\n" + Constants.MISSATGE_CATALEG );
        Consola.escriu("\n" + Constants.MISSATGE_RANKING);
        
        Consola.escriu("\n\n" + Constants.MISSATGE_SELECCIO_MENU_PRINCIPAL);
        
        int i = Consola.llegeixInt();
        
        Consola.escriu("\n");
        
        String result = controller.opcioSeleccionada(i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu(result + "\n\n");
            show();
        }
        
    }
    
}
