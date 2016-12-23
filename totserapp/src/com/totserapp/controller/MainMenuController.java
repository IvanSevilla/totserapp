package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.util.Constants;
import com.totserapp.view.CatalegView;
import com.totserapp.view.RankingView;
import com.totserapp.view.RegistreView;
import com.totserapp.view.View;

public class MainMenuController extends Controller{
    
    public MainMenuController(View view) {
        super(view);
    }
    
    public String opcioSeleccionada(int i){
        switch(i){
            case Constants.OPCIO_REGISTRE:
                //TotSeries.getInstance().setView(new RegistreView());
                return Constants.OK;
            case Constants.OPCIO_CATALEG:
                //TotSeries.getInstance().setView(new CatalegView());
                return Constants.OK;
            case Constants.OPCIO_RANKING:
                //TotSeries.getInstance().setView(new RankingView());
                return Constants.OK;
        }
        return Constants.ERROR_OPCIO_INCORRECTE;
    }
    
}
