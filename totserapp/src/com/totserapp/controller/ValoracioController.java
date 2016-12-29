package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Serie;
import com.totserapp.view.ValoracioEpisodiView;
import com.totserapp.view.ValoracioSerieAdminView;
import com.totserapp.view.View;

public class ValoracioController extends Controller{
    
    public ValoracioController(View view) {
        super(view);
    }
    
    public void valorarEpisodi(Episodi episodi, int valoracio){
        episodi.valorar(TotSeries.getInstance().getUsuariActual(), valoracio);
        ((ValoracioEpisodiView)getView()).getParentView().getController().mostrarRankingValoracions();
        getView().dispose();
    }
    
    public void valorarSerie(Serie serie, int valoracio){
        serie.valorar(TotSeries.getInstance().getUsuariActual(), valoracio);
        ((ValoracioSerieAdminView)getView()).getParentView().getController().mostrarRankingValoracions();
        getView().dispose();
    }
}
