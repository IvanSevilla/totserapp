package com.totserapp.model;

public class Artista {
     private String nom, nacionalitat;

    public Artista(String nom, String nacionalitat) {
        this.nom = nom;
        this.nacionalitat = nacionalitat;
    }
    
    @Override
    public String toString(){
//		System.out.println("\nArtista amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Tipus: " + tipus);
//		System.out.println("Serie ID: " + idSerie);
//                System.out.println("Nacionalitat: " + nacionalitat);
        return "Artista";
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNacionalitat() {
        return nacionalitat;
    }
    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }
}
