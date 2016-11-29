package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.controller.SerieController;
import com.totserapp.model.Episodi;
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
        Consola.escriu("TOT SERIES - " + serie.getTitol());
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        Consola.escriu("\n" + serie.toString());
        
        String result = controller.visualitzarSerie(serie);
        
        Consola.escriu(result);
        
        Consola.escriu("\n\nSelecciona una episodi per visualitzar (1-" + controller.getEpisodiCount() + ") o torna al menu anterior (0): ");
        
        int i = Consola.llegeixInt();
        
        result = controller.seleccionarEpisodi(serie, i);
        
        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu("\nOpció incorrecte.");
            show();
        }else if(result.equals(Constants.ERROR_USUARI_NO_LOGUEJAT)){
            Consola.escriu("\nNo es pot veure un episodi sense un usuari loguejat.");
            show();
        }else if(!result.equals(Constants.OK)){
            Consola.escriu("\n" + result);
            Consola.escriu("\n\nVols valorar l'episodi? \n (1) - Si, (2) - No : ");
            
            i = Consola.llegeixInt();
            
            result = controller.seleccionarOpcioValorar(i);
            
            if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
                Consola.escriu("\nOpció incorrecte.");
                show();
            }else if(result.equals(Constants.SI)){
                Consola.escriu("\nFes una valoració (1-5): ");
                
                i = Consola.llegeixInt();
                result = controller.valorarEpisodi(i);
                
                if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
                     Consola.escriu("\nOpció incorrecte.");
                     show();
                }else{
                    Consola.escriu("\n"+result);
                    TotSeries.getInstance().setView(new CatalegView());
                }
            }
            
        }
        
        Consola.escriu("\n");
        
    }
}
