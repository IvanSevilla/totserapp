package com.totserapp;

import com.totserapp.model.Usuari;
import com.totserapp.util.TotSeriesDataManager;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.View;

public class TotSeries {
    private View view;
    private TotSeriesDataManager dataManager;
    private Usuari usuariActual;
    
    private static TotSeries instance = null;
    
    public TotSeries(){
        dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
    }
    
    public static TotSeries getInstance(){
        if(instance == null) instance = new TotSeries();
        return instance;
    }
    
    public static void main(String[] args){
       getInstance().setView(new MainMenuView());
    }
    
    public void setView(View view){
        this.view = view;
        this.view.show();
    }
    
    public TotSeriesDataManager getDataManager(){
        return dataManager;
    }
    
    public View getView(){
        return view;
    }
    
    public Usuari getUsuariActual(){
        return usuariActual;
    }
    
    public void setUsuariActual(Usuari usuari){
        this.usuariActual = usuari;
    }
}
