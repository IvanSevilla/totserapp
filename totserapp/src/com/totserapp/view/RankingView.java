package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.controller.RankingController;
import com.totserapp.model.Episodi;
import com.totserapp.util.Consola;
import java.util.ArrayList;

public class RankingView extends View{
    private RankingController controller = new RankingController(this);
    
    @Override
    public void show() {
        Consola.escriu("TOT SERIES - EPISODIS MES VALORATS");
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        TotSeries totSeries = TotSeries.getInstance();
        ArrayList<Episodi> episodis = totSeries.getDataManager().getEpisodisMesValorats();
        
        for(Episodi episodi: episodis){
            Consola.escriu("\n" + episodi.toShortString() + " - " + episodi.getMitjanaValoracions());
        }
    }
}
