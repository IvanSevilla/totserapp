package com.totserapp.util;

import com.totserapp.model.TestClient;
import java.util.ArrayList;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {

	/* -------------------------------------------------------------------
	 * Metodes a implementar per vosaltres. En aquests metodes creareu els
	 * vostres objectes a partir de la informacio obtinguda del fitxer XML
	 * 
	 * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
	 * dades que retorna el metode, es a dir que sou lliures de
	 * modificar-ho al gust, excepte les crides inicials que es fan.
	 * -------------------------------------------------------------------
	 */
    
        private ArrayList<TestClient> clients = new ArrayList<>();

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
            TestClient client = new TestClient(id, nom, dni, adreca, usuari, password, vip);
            clients.add(client);
	}

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
         * @param desc descripcio de la serie
	 */
	
	public void crearSerie(String id, String title, String desc) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova serie.
		 */

//		System.out.println("\nSerie amb ID: " + id);
//		System.out.println("--------------------------------------------------");
//		System.out.println("Titol: " + title);
//		System.out.println("Descripció: " + desc);
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

		/* TODO: Aqui feu el necessari per a crear els artistes per a la serie
		 */

//		System.out.println("\nArtista amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Tipus: " + tipus);
//		System.out.println("Serie ID: " + idSerie);
//                System.out.println("Nacionalitat: " + nacionalitat);
	}
	
		
	/**
	 * Crea productora del fitxer XML
	 * 
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public void crearProductora (String id, String nom, String idSerie) {

		/* TODO: Aqui feu el necessari per a crear les productores per a les series
		 */

//		System.out.println("\nProductora amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Serie ID: " + idSerie);
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

		/* TODO: A partir d'aqui creeu la valoracio
		 */
//		System.out.println("\nValoracio amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Client: " + client);
//		System.out.println("Episodi: " + episodi);
//		System.out.println("Puntuacio: " + puntuacio);
//		System.out.println("Data: " + data);
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

		/* TODO: Creeu aqui el vostre admin
		 */

//		System.out.println("\nAdmin ID: " + id);
//		System.out.println("-----------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Usuari: " + usuari);
//		System.out.println("Password: " + password);
	}

    public ArrayList<TestClient> getClients() {
        return clients;
    }
        
        
        
        

	
}
