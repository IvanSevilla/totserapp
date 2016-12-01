package com.totserapp.view;

import com.totserapp.controller.RankingController;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class RankingView extends View{
    private RankingController controller = new RankingController(this);
    
    @Override
    public void show() {
        Consola.escriu(Constants.MISSATGE_NOM_APLICACIO + " - EPISODIS MES VALORATS");
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        String result = controller.visualitzarRanking();
        
        Consola.escriu(result);
        
        Consola.escriu("\n\nSelecciona un episodi per visualitzar (1-" + controller.getEpisodis().size() + ") o torna al menu anterior (0): ");
        
        int i = Consola.llegeixInt();
        
        result = controller.seleccionarOpcio(i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu("\n" + result);
            show();
        }else if(result.equals(Constants.ERROR_USUARI_NO_LOGUEJAT)){
            Consola.escriu("\n" + result + "\n\n");
            show();
        }
    }
}
