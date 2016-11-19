package com.totserapp.model;

public class TestClient {
    
    String id, nom, dni, adreca, usuari, password, vip;

    public TestClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip) {
        this.id  = id;
        this.nom = nom;
        this.dni = dni;
        this.adreca = adreca;
        this.usuari = usuari;
        this.password = password;
    }

    @Override
    public String toString() {
        String out = "";
        out += "\nClient ID: " + id;
	out += "\n-----------------";
	out += "\nNom: " + nom;
	out += "\nUsuari: " + usuari;
	out += "\nDni: " + dni;
	out += "\nAdreça: " + adreca;
	out += "\nPassword: " + password;
	out += "\nEs VIP: " + vip;
        return out;
    }
    
    
   
}
