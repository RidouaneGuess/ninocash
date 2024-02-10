package com.example.fabi.Model;

public class Revenu extends Transaction {

    private String source;

    public Revenu(String date, double montant,String desciption,String source) {
        super(date, montant, "Revenu",desciption);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String getDetails() {
        return "Source: " + source;
    }
}
