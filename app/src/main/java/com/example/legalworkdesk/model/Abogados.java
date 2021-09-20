package com.example.legalworkdesk.model;

import java.io.Serializable;

public class Abogados extends Serializable {

    private int id;
    private double honorarios;
    private double timbres;

    public Abogados(int id, double honorarios, double timbres) {
        this.id = id;
        this.honorarios = honorarios;
        this.timbres = timbres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }

    public double getTimbres() {
        return timbres;
    }

    public void setTimbres(double timbres) {
        this.timbres = timbres;
    }
}