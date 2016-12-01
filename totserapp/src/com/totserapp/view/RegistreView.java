package com.totserapp.view;

import com.totserapp.controller.RegistreController;
import com.totserapp.util.Consola;
import com.totserapp.util.Constants;

public class RegistreView extends View{
    private RegistreController controller = new RegistreController(this);
    
    @Override
    public void show() {
        Consola.escriu(Constants.MISSATGE_NOM_APLICACIO + " - Registre");
        imprimirEstatUsuari();
        Consola.escriu("\n==========");
        
        Consola.escriu("\n\nIntrodueix nom: ");
        String nom = Consola.llegeixString();
        
        Consola.escriu("Introdueix nick: ");
        String nick = Consola.llegeixString();
        
        Consola.escriu("Introdueix password: ");
        String password = Consola.llegeixString();
        
        Consola.escriu("Introdueix adreça: ");
        String adreca = Consola.llegeixString();

        Consola.escriu("Introdueix dni: ");
        String dni = Consola.llegeixString();
        
        String result = controller.registrar(nom, nick, password, adreca, dni);
        
        if(result.equals(Constants.OK)){
            Consola.escriu("\nUsuari " + nick + " creat correctament!\n\n");
            controller.mostrarMenuPrincipal();
        }else{
            Consola.escriu("\nL'usuari no s'ha creat.\n");
            show();
        }
        
    }
}
