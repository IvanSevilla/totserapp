package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Serie;
import com.totserapp.util.Constants;
import com.totserapp.view.MainMenuView;
import com.totserapp.view.SerieView;
import com.totserapp.view.View;
import java.util.Map;

public class CatalegController extends Controller{
    
    public CatalegController(View view) {
        super(view);
    }
    
    public String visualitzarCataleg(){
        String cataleg = "";
        TotSeries totSeries = TotSeries.getInstance();
        
        int i = 1;
        for(Map.Entry<String, Serie> entry : totSeries.getDataManager().getSeries().entrySet()) {
            Serie serie = entry.getValue();
            cataleg += "(" + i + ") - ";
            cataleg += serie.toString();
            cataleg += "\n\n";
            i++;
        }
        
        return cataleg;
    }
    
    public String opcioSeleccionada(int i){
        if(i >= 1 && i <= 10){
            Serie serie = getSerieAtPosition(i);
            TotSeries.getInstance().setView(new SerieView(serie));
            return Constants.OK;
        }else if(i == 0){
            TotSeries.getInstance().setView(new MainMenuView());
            return Constants.OK;
        }
        return Constants.ERROR_OPCIO_INCORRECTE;
    }
    
    private Serie getSerieAtPosition(int i){
        Map.Entry<String, Serie> entry = (Map.Entry<String, Serie>)TotSeries.getInstance().getDataManager().getSeries().entrySet().toArray()[i - 1];
        return entry.getValue();
    }
}
