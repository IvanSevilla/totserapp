package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Usuari;
import com.totserapp.util.Constants;
import com.totserapp.view.EpisodiView;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.View;
import java.util.ArrayList;

public class RankingController extends Controller{
    
    private ArrayList<Episodi> episodis;
    public RankingController(View view) {
        super(view);
        
        TotSeries totSeries = TotSeries.getInstance();
        episodis = totSeries.getDataManager().getEpisodisMesValorats();
    }
    
    public String visualitzarRanking(){
        String out = "";
        for(int i = 0; i < episodis.size(); i++){
            Episodi episodi = episodis.get(i);
            String estrellas = "";
            int mitjana = episodi.getMitjanaValoracions();
            for(int j = 0; j < mitjana; j++){
                 estrellas += "★";
            }
            out += "\n(" + (i+1) + ") - " + episodi.getSerie() + ": " + episodi.toShortString() + " | Valoració: " + estrellas;
        } 
        
        return out;
    }
    
    public String seleccionarOpcio(int i){
        if(i == 0){
            //TotSeries.getInstance().setView(new MainMenuView());
            return Constants.OK;
        }else if(i >= 1 && i <= episodis.size()){
            Usuari usuari = TotSeries.getInstance().getUsuariActual();
            if(usuari != null){
                //TotSeries.getInstance().setView(new EpisodiView(episodis.get(i)));
                return Constants.OK;
            }else{
                return Constants.ERROR_USUARI_NO_LOGUEJAT;
            }
        }
        
        return Constants.ERROR_OPCIO_INCORRECTE;
    }

    public ArrayList<Episodi> getEpisodis() {
        return episodis;
    }
    
}
