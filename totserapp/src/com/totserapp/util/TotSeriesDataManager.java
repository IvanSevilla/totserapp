package com.totserapp.util;

import com.totserapp.TotSeries;
import com.totserapp.model.Actor;
import com.totserapp.model.Admin;
import com.totserapp.model.Artista;
import com.totserapp.model.Client;
import com.totserapp.model.ClientVIP;
import com.totserapp.model.Director;
import com.totserapp.model.Episodi;
import com.totserapp.model.Productora;
import com.totserapp.model.Serie;
import com.totserapp.model.Usuari;
import com.totserapp.model.Valoracio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {

    private HashMap<String, Usuari> usuaris = new HashMap<>();
    private HashMap<String, Serie> series = new HashMap<>();

    /**
     * Obté les dades del fitxer XML passat per paràmetre
     * 
     * @param nomFitxer ruta del fitxer XML del que obtenir les dades
     */
    public void obtenirDades(String nomFitxer) {
            TotSeriesXMLParser parser = new TotSeriesXMLParser(this);
            parser.parse(nomFitxer);
    }

    /**
     * Crea un nou client a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id del client
     * @param nom nom del client
     * @param dni dni del client
     * @param adreca adreça del client
     * @param usuari usuari al sistema del client
     * @param password password del client
     * @param vip true si el client es vip. false si no
      */

    public void crearClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip) {
        Usuari u = null;

        if(vip.equals("true")){
            u = new Client(nom, usuari, password, adreca, dni);
        }else{
            u = new ClientVIP(nom, usuari, password, adreca, dni);
        }

        if(u != null) usuaris.put(usuari, u);
    }

    /**
     * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id de la serie. El podeu utilitzar o no
     * @param title títol de la serie
     * @param desc descripcio de la serie
     */

    public void crearSerie(String id, String title, String desc) {		
        Serie serie = new Serie(title, desc);
        series.put(id, serie);

    }
    
    public void crearTemporada(String idSerie, String numTemporada, String numEpisodis) {
        //series.get(idSerie)
//        System.out.println("Temporada: " + numTemporada + " Numero Episodis: "+ numEpisodis);
//        System.out.println("--------------------------------------------------");
    }
    
    public void crearEpisodi(String idSerie, String numTemporada, int numEpisodi, String title, String duration, String idioma, String description, String data) {		
        Episodi episodi = new Episodi(title, idioma, description, data, duration, numTemporada, numEpisodi, series.get(idSerie).getTitol());
        series.get(idSerie).getEpisodis().add(episodi);
    }

    /**
     * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id del artista. El podeu utilitzar o no
     * @param nom nom del artista
     * @param tipus tipus (director\actor) del artista
     * @param idSerie serie a la qual treballa. El podeu utilitzar o no
     * @param nacionalitat 
     */

    public void crearArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {
        Artista artista = null;
        if(tipus.equals("director")){
            artista = new Director(nom, nacionalitat);
        }else if(tipus.equals("actor")){
            artista = new Actor(nom, nacionalitat);
        }
        
        if(artista != null) series.get(idSerie).getArtistes().add(artista);
    }


    /**
     * Crea productora del fitxer XML
     * 
     * @param id id de la productora
     * @param nom nom de la productora
     * @param idSerie id de la serie que va fer. El podeu utilitzar o no
     */
    public void crearProductora (String id, String nom, String idSerie) {
        Productora productora = new Productora(nom);
        series.get(idSerie).setProductora(productora);

    }

    /**
     * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id de la valoracio. El podeu utilitzar o no
     * @param client identificador del client. El podeu utilitzar o no
     * @param episodi identificador de la serie. El podeu utilitzar o no
     * @param puntuacio puntuacio donada al episodi
     * @param data data en la que es va fer la puntuacio
     */

    public void crearValoracio(String id, String client, String episodi, String puntuacio, String data) {
        Valoracio valoracio = new Valoracio(Integer.parseInt(puntuacio), client);
    }

    /**
     * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id del administrador
     * @param nom nom del administrador
     * @param usuari usuari del administrador
     * @param password password del administrador
     */

    public void crearAdmin(String id, String nom, String usuari, String password) {
        Usuari u = new Admin(nom, usuari, password, null, null);
        usuaris.put(usuari, u);
    }

    public HashMap<String, Usuari> getUsuaris() {
        return usuaris;
    }
    
    public HashMap<String, Serie> getSeries() {
        return series;
    }	
}
