package com.totserapp.view;

import com.totserapp.controller.RankingController;
import com.totserapp.util.Consola;

public class RankingView extends View{
    private RankingController controller = new RankingController(this);
    
    @Override
    public void show() {
        Consola.escriu("Ranking");
    }
}
