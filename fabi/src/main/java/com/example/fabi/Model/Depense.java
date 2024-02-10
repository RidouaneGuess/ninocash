package com.example.fabi.Model;

public class Depense extends Transaction {

    private String categorie;

    public Depense(String date, double montant, String description,String categorie) {
        super(date, montant, "Dépense",description);
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String getDetails() {
        return "Catégorie: " + categorie;
    }
}

