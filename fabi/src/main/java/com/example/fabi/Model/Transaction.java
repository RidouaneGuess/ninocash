package com.example.fabi.Model;

public abstract class Transaction {

    private String date;
    private double montant;
    private String type;
    private String description;

    public Transaction(String date, double montant, String type,String description) {
        this.date = date;
        this.montant = montant;
        this.type = type;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }

    public abstract String getDetails();
}
