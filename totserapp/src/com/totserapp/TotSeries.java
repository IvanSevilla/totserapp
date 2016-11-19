package com.totserapp;

import com.totserapp.util.TotSeriesDataManager;
import com.totserapp.view.TestView;
import com.totserapp.view.View;


public class TotSeries {
    private static View view;
    private static TotSeriesDataManager dataManager;
    
    public static void main(String[] args){
        dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        
        setView(new TestView());
    }
    
    public static TotSeriesDataManager getDataManager(){
        return dataManager;
    }
    
    public static void setView(View view){
        TotSeries.view = view;
        TotSeries.view.show();
    }
}
