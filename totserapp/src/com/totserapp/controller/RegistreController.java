package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Usuari;
import com.totserapp.util.Constants;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.View;

public class RegistreController extends Controller{
    
    public RegistreController(View view) {
        super(view);
    }
    
    public String registrar(String nom, String nick, String password, String adreca, String dni){
        TotSeries totSeries = TotSeries.getInstance();
        boolean jaCreat = totSeries.getDataManager().getUsuaris().containsKey(nick);
        if(jaCreat) return Constants.ERROR_REGISTRE_INCORRECTE; 
        else{
            totSeries.getDataManager().crearClient(" ", nom, dni, adreca, nick, password, "false");
            Usuari usuari = totSeries.getDataManager().getUsuaris().get(nick);
            totSeries.setUsuariActual(usuari);
        }
        
        return Constants.OK;
    }
    
    public void mostrarMenuPrincipal(){
        TotSeries.getInstance().setView(new MainMenuView());
    }
}
