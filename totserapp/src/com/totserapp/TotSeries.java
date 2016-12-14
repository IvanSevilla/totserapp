package com.totserapp;

import com.totserapp.model.Usuari;
import com.totserapp.util.TotSeriesDataManager;
import com.totserapp.view.JFrameView;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.TestJFrameView;
import com.totserapp.view.View;

/**
 * Classe principal de l'aplicació. És un singleton. 
 * Conté una instancia del DataManager, la vista que 
 * s'està mostrant actualment i l'usuari loguejat.
 * 
 */
public class TotSeries {
    private JFrameView view;
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
       getInstance().showJFrameView(new TestJFrameView());
    }
    
    public void setView(View view){
        //this.view = view;
        // Mostrem la vista!
        this.view.show();
    }
    
    public void showJFrameView(JFrameView view){
        this.view = view;
        this.view.mostrar();
    }
    
    public TotSeriesDataManager getDataManager(){
        return dataManager;
    }
    
    public JFrameView getView(){
        return view;
    }
    
    public Usuari getUsuariActual(){
        return usuariActual;
    }
    
    public void setUsuariActual(Usuari usuari){
        this.usuariActual = usuari;
    }
}
