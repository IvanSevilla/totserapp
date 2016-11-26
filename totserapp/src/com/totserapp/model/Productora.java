package com.totserapp.model;

public class Productora {
    private String nom;

    public Productora(String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString(){
//		System.out.println("\nProductora amb ID: " + id);
//		System.out.println("--------------------------------------");
//		System.out.println("Nom: " + nom);
//		System.out.println("Serie ID: " + idSerie);
        return "Productora";
    }
    


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
