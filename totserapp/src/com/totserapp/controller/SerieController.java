package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Serie;
import com.totserapp.model.Usuari;
import com.totserapp.util.Constants;
import com.totserapp.view.CatalegView;
import com.totserapp.view.EpisodiView;
import com.totserapp.view.SerieView;
import com.totserapp.view.View;

public class SerieController extends Controller{
    
    private int count;
    private Episodi seleccionat;
    
    public SerieController(View view) {
        super(view);
    }
    
    public String visualitzarSerie(Serie serie){
        String out = "";
        count = 0;
        for(Episodi episodi: serie.getEpisodis()){
            count++;
            out += "\n(" + count + ") - " + episodi.toShortString();
        }
        return out;
    }
    
    public int getEpisodiCount(){
        return count;
    }
    
    public String seleccionarEpisodi(Serie serie, int i){
        if(i >= 1 && i <= count){
            Usuari usuari = TotSeries.getInstance().getUsuariActual();
            if(usuari != null){
                Episodi episodi = getEpisodiAtPosition(serie, i);
                seleccionat = episodi;
                //TotSeries.getInstance().setView(new EpisodiView(episodi));
                return Constants.OK;
            }else{
                return Constants.ERROR_USUARI_NO_LOGUEJAT;
            }
        }else if(i == 0){
            //TotSeries.getInstance().setView(new CatalegView());
            return Constants.OK;
        }
        
        return Constants.ERROR_OPCIO_INCORRECTE;
    }
    
    public String seleccionarOpcioValorar(int i){
        if(i == 1){
            return Constants.SI;
        }else if(i == 2){
            return Constants.NO;
        }
        return Constants.ERROR_OPCIO_INCORRECTE;
    }
    
    public String valorarEpisodi(int valor){
        if(valor >= 1 && valor <= 5){
            Usuari usuari = TotSeries.getInstance().getUsuariActual();
            seleccionat.valorar(usuari, valor);
            String estrellas = "";
            for(int i = 0; i < valor; i++){
                estrellas += "★";
            }
            return "Episodi valorat! " + estrellas;
        }
        
        return Constants.ERROR_OPCIO_INCORRECTE;
    }
    
    public String visualitzarEpisodi(Episodi episodi){
        return "\nVisualitzant Episodi " + episodi.getTitle() + "...";
    }
    
    private Episodi getEpisodiAtPosition(Serie serie, int i){
        return serie.getEpisodis().get(i);
    }
    
}
