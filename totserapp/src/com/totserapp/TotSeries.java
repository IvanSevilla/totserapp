package com.totserapp;

import com.totserapp.model.Usuari;
import com.totserapp.util.TotSeriesDataManager;
import com.totserapp.view.View;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.MainView;
import com.totserapp.view.View;

/**
 * Classe principal de l'aplicació. És un singleton. 
 * Conté una instancia del DataManager, la vista que 
 * s'està mostrant actualment i l'usuari loguejat.
 * 
 */
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
       getInstance().showView(new MainView());
    }
    
    public void showView(View view){
        this.view = view;
        this.view.mostrar();
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
