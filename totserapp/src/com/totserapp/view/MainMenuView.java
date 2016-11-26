package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.controller.MainMenuController;
import com.totserapp.model.Usuari;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class MainMenuView extends View{
    MainMenuController controller = new MainMenuController(this);
    
    @Override
    public void show() {
        Consola.escriu("TOT SERIES");
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        Consola.escriu("\n(1) - Alta nou client");
        Consola.escriu("\n(2) - Visualitzar Catàleg");
        Consola.escriu("\n(3) - Episodis més valorats");
        
        Consola.escriu("\n\nIntrodueix un número (1-3): ");
        
        int i = Consola.llegeixInt();
        
        Consola.escriu("\n");
        
        String result = controller.opcioSeleccionada(i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu(result + "\n\n");
            show();
        }
        
    }
    
}
