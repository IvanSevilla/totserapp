
package com.totserapp.model;

import java.util.HashMap;

public class Serie {
    private HashMap<String, Artista> artistes = new HashMap<>();
    private HashMap<String, Episodi> episodis =  new HashMap<>();
    
    private Productora productora;

   
    private String titol, descripcio;
    
    public HashMap<String, Episodi> getEpisodis() {
        return episodis;
    }
    public HashMap<String, Artista> getArtistes() {
        return artistes;
    }

    public Serie(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
    }
    
    @Override
    public String toString(){
//		System.out.println("\nSerie amb ID: " + id);
//		System.out.println("--------------------------------------------------");
//		System.out.println("Titol: " + title);
//		System.out.println("Descripció: " + desc);
        return "Serie";
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }
    
    public Productora getProductora(){
        return productora;
    }
   
}
