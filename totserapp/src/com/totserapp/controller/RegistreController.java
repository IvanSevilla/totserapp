/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totserapp.controller;

import com.totserapp.TotSeries;
import com.totserapp.model.Usuari;
import com.totserapp.util.Constants;
import com.totserapp.view.ErrorView;
import com.totserapp.view.MainView;
import com.totserapp.view.View;

public class RegistreController extends Controller{
    
    public RegistreController(View view) {
        super(view);
    }
    
    public void registrar(MainView mainView, String nom, String nick, String password, String adreca, String dni){
        TotSeries totSeries = TotSeries.getInstance();
        boolean jaCreat = totSeries.getDataManager().getUsuaris().containsKey(nick);
        boolean error = jaCreat || nick.isEmpty() || password.isEmpty();
        if(error){
            TotSeries.getInstance().showView(new ErrorView(Constants.ERROR_REGISTRE_INCORRECTE));
        }else{
            totSeries.getDataManager().crearClient(" ", nom, dni, adreca, nick, password, "false");
            Usuari usuari = totSeries.getDataManager().getUsuaris().get(nick);
            totSeries.setUsuariActual(usuari);
            mainView.mostrarUsuariLoguejat(usuari);
            System.out.println("Usuari creat:" + usuari.getNick());
        }
    }
    
}
