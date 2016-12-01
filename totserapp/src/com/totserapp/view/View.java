package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.model.Usuari;
import com.totserapp.util.Consola;

/**
 * Classe vista base que serà pare de tota la resta de vistes.
 * La vista s'encarrega de mostrar les dades de l'aplicació
 * i les obté del controlador. Ara es una interfície per consola, 
 * però com està estructurat en un futur es pot convertir en una 
 * interfície gràfica.
 */
public class View {
    
    /**
     * Mostra les dades de la vista per consola
     * 
     */
    public void show(){
        
    }
    
    /**
     * Mostra l'estat del usuari al sistema. Si està loguejat o no.
     * 
     */
    public void imprimirEstatUsuari(){
        Usuari usuari = TotSeries.getInstance().getUsuariActual();
        if(usuari != null){
            Consola.escriu("\nLoguejat amb usuari: " + usuari.getNick() + "."); 
        }else{
            Consola.escriu("\nNo hi ha cap usuari loguejat."); 
        }
    }
}
