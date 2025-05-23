package fr.diginamic.jdbc.entites;

public class Fournisseur {
    int id;
    String nom;

    // Constructeur
    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "ID : " + id + " Nom : " + nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
