package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Serie;
import com.totserapp.view.MainView;
import com.totserapp.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainController extends Controller{
    
    public MainController(View view) {
        super(view);
    }
    
    public void init(){
        mostrarSeries();
        mostrarRankingValoracions();
    }
    
    public void mostrarSeries(){
        HashMap<String, Serie> series = TotSeries.getInstance().getDataManager().getSeries();
        ((MainView)getView()).setList1Series(series);
    }
    
    public void mostrarEpisodis(int index, int temporada){
        HashMap<String, Serie> series = TotSeries.getInstance().getDataManager().getSeries();
        ArrayList<Episodi> episodis = ((Map.Entry<String, Serie>)series.entrySet().toArray()[index]).getValue().getEpisodis();
        ArrayList<Episodi> out = new ArrayList<>();
        for(Episodi episodi: episodis){
            if(Integer.parseInt(episodi.getNumTemporada()) == temporada) out.add(episodi);
        }
        
        int numTemporades = Integer.parseInt(episodis.get(episodis.size() - 1).getNumTemporada());
        ((MainView)getView()).setList1Episodis(out);
        ((MainView)getView()).setTemporades(numTemporades);
    }
    
    public void mostrarRankingValoracions(){
        ArrayList<Episodi> episodis = TotSeries.getInstance().getDataManager().getEpisodisMesValorats();
        ((MainView)getView()).setList3Episodis(episodis);
    }
}
