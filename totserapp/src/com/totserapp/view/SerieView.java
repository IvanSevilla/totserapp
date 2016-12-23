package com.totserapp.view;

import com.totserapp.controller.SerieController;
import com.totserapp.model.Serie;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class SerieView extends View{
    private SerieController controller = new SerieController(this);
    private Serie serie;
    
    public SerieView(Serie serie){
        this.serie = serie;
    }
    
    @Override
    public void show() {
        Consola.escriu(Constants.MISSATGE_NOM_APLICACIO + " - " + serie.getTitol());
        //imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        Consola.escriu("\n" + serie.toString());
        
        String result = controller.visualitzarSerie(serie);
        
        Consola.escriu(result);
        
        Consola.escriu("\n\nSelecciona un episodi per visualitzar (1-" + controller.getEpisodiCount() + ") o torna al menu anterior (0): ");
        
        int i = Consola.llegeixInt();
        
        result = controller.seleccionarEpisodi(serie, i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu("\nOpció incorrecte.");
            show();
        }else if(result.equals(Constants.ERROR_USUARI_NO_LOGUEJAT)){
            Consola.escriu("\n" + result + "\n\n");
            show();
        }
        
        Consola.escriu("\n");
    }
}
