package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.model.Usuari;
import com.totserapp.util.Consola;

public class View {
    public void show(){
        
    }
    
    public void imprimirEstatUsuari(){
        Usuari usuari = TotSeries.getInstance().getUsuariActual();
        if(usuari != null){
            Consola.escriu("\nLoguejat amb usuari: " + usuari.getNick() + "."); 
        }else{
            Consola.escriu("\nNo hi ha cap usuari loguejat."); 
        }
    }
}
