package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Serie;
import com.totserapp.view.MainView;
import com.totserapp.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        String[] rankingValoracions = getSeriesMesValorades(); 
        ((MainView)getView()).setList3Episodis(rankingValoracions);
    }
    
    public String[] getSeriesMesValorades(){
        String[] out = new String[10];
        ArrayList<Serie> s = new ArrayList<>();
        
        // calcular valoracion media serie
        for(Map.Entry<String, Serie> entry : TotSeries.getInstance().getDataManager().getSeries().entrySet()) {
           Serie serie = entry.getValue();
           int numEpisodis = serie.getEpisodis().size();
           int valoracioAcum = 0;
           for(Episodi episodi : serie.getEpisodis()){
               valoracioAcum += episodi.getMitjanaValoracions();
           }

           int result = valoracioAcum / numEpisodis;
           serie.setValoració(result);
           s.add(serie);
        }
        
        // ordenar por valoracion
        
        Collections.sort(s, new Comparator<Serie>() {
            @Override
            public int compare(Serie a, Serie b) {
                if(a.getValoració() > b.getValoració()){
                    return -1; 
                }if(a.getValoració() < b.getValoració()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        
        // obtener las 10 primeras y formatear
        for(int i = 0; i < 10 ; i++){
            Serie serie = s.get(i);
            out[i] = serie.getTitol() + " - " + serie.getValoració();
        }
        
        return out;
    }
}
