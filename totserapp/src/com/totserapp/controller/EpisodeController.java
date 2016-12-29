package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.view.EpisodeView;
import com.totserapp.view.MainView;
import com.totserapp.view.ValoracioEpisodiView;
import com.totserapp.view.View;


public class EpisodeController extends Controller{
    
    public EpisodeController(View view) {
        super(view);
    }
    
    public void visualitzar(Episodi episodi){
        episodi.addVisualitzacions();
        ((EpisodeView)getView()).getParentView().getController().mostrarRankingVisualitzacions();
        TotSeries.getInstance().showView(new ValoracioEpisodiView(((EpisodeView)getView()).getParentView(), episodi));
    }
    
}
