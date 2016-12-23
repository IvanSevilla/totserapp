package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.controller.SerieController;
import com.totserapp.model.Episodi;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class EpisodiView extends View{
    private SerieController controller = new SerieController(this);
    private Episodi episodi;
    
    public EpisodiView(Episodi episodi){
        this.episodi = episodi;
    }
    
    @Override
    public void show() {
        Consola.escriu(Constants.MISSATGE_NOM_APLICACIO + " - " + episodi.toShortString());
        //imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        String result = controller.visualitzarEpisodi(episodi);
        
        Consola.escriu(result);
        
        Consola.escriu("\n\nVols valorar l'episodi? \n (1) - Si, (2) - No : ");

        int i = Consola.llegeixInt();

        result = controller.seleccionarOpcioValorar(i);

        if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
            Consola.escriu("\n" + result);
            show();
        }else if(result.equals(Constants.SI)){
            Consola.escriu("\n" + Constants.MISSATGE_VALORAR);

            i = Consola.llegeixInt();
            result = controller.valorarEpisodi(i);

            if(result.equals(Constants.ERROR_OPCIO_INCORRECTE)){
                 Consola.escriu("\n" +result);
                 show();
            }else{
                Consola.escriu("\n" + result);
                //TotSeries.getInstance().setView(new CatalegView());
            }
        }
    }
}
