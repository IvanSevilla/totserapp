package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import com.totserapp.model.Serie;
import com.totserapp.model.Usuari;
import com.totserapp.util.Constants;
import com.totserapp.view.EpisodeView;
import com.totserapp.view.ErrorView;
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
        mostrarRankingVisualitzacions();
    }
    
    public void mostrarSeries(){
        HashMap<String, Serie> series = TotSeries.getInstance().getDataManager().getSeries();
        ((MainView)getView()).setList1Series(series);
    }
    
    public void mostrarEpisodis(int serie, int temporada){
        HashMap<String, Serie> series = TotSeries.getInstance().getDataManager().getSeries();
        ArrayList<Episodi> episodis = ((Map.Entry<String, Serie>)series.entrySet().toArray()[serie]).getValue().getEpisodis();
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
        ((MainView)getView()).setRankingSeriesMesValorades(rankingValoracions);
    }
    
    public void mostrarRankingVisualitzacions(){
        String[] rankingVisualitzacions = getSeriesMesVistes(); 
        ((MainView)getView()).setRankingSeriesMesVistes(rankingVisualitzacions);
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
    
    public String[] getSeriesMesVistes(){
        String[] out = new String[10];
        ArrayList<Serie> s = new ArrayList<>();
        
        // calcular valoracion media serie
        for(Map.Entry<String, Serie> entry : TotSeries.getInstance().getDataManager().getSeries().entrySet()) {
           Serie serie = entry.getValue();
           int result = 0;
           for(Episodi episodi : serie.getEpisodis()){
               result += episodi.getVisualitzacions();
           }

           serie.setVisualitzacions(result);
           s.add(serie);
        }
        
        // ordenar por valoracion
        
        Collections.sort(s, new Comparator<Serie>() {
            @Override
            public int compare(Serie a, Serie b) {
                if(a.getVisualitzacions()> b.getVisualitzacions()){
                    return -1; 
                }if(a.getVisualitzacions() < b.getVisualitzacions()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        
        // obtener las 10 primeras y formatear
        for(int i = 0; i < 10 ; i++){
            Serie serie = s.get(i);
            out[i] = serie.getTitol() + " - " + serie.getVisualitzacions();
        }
        
        return out;
    }
    
    public void login(String username, String password){
        Usuari usuari = TotSeries.getInstance().getDataManager().getUsuaris().get(username);
        
        if(usuari == null){
            TotSeries.getInstance().showView(new ErrorView(Constants.ERROR_USUARI_INCORRECTE));
        }else{
            if(!password.equals(usuari.getPassword())){
                TotSeries.getInstance().showView(new ErrorView(Constants.ERROR_CONTRASENYA_INCORRECTE));
            }else{
                ((MainView)getView()).mostrarUsuariLoguejat(usuari);
                TotSeries.getInstance().setUsuariActual(usuari);
            }
        }
    }
    
    public void sortir(){
        TotSeries.getInstance().setUsuariActual(null);
    }
    
    public void visualitzarEpisodi(int serie, int temporada, int episodi){
        if(TotSeries.getInstance().getUsuariActual() == null){
            TotSeries.getInstance().showView(new ErrorView(Constants.ERROR_USUARI_NO_LOGUEJAT));
            return;
        }
        
        HashMap<String, Serie> series = TotSeries.getInstance().getDataManager().getSeries();
        ArrayList<Episodi> episodis = ((Map.Entry<String, Serie>)series.entrySet().toArray()[serie]).getValue().getEpisodis();
        ArrayList<Episodi> out = new ArrayList<>();
        for(Episodi e: episodis){
            if(Integer.parseInt(e.getNumTemporada()) == temporada) out.add(e);
        }
        
        TotSeries.getInstance().showView(new EpisodeView(out.get(episodi)));
    }
    
    
}
