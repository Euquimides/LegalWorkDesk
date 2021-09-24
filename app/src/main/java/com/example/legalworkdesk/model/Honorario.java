package com.example.legalworkdesk.model;

import java.io.Serializable;

public class Honorario implements Serializable {

    private String proceso;

    public Honorario(String proceso) {
        this.proceso = proceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    // --------------------------- Código Anterior ---------------------------------------
    //    private int id;
//    private String nombre;
//    private double honorarios;
//    private double timbres;
//
//    public Honorario(int id, String nombre, double honorarios, double timbres) {
//        this.id = id;
//        this.honorarios = honorarios;
//        this.timbres = timbres;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public double getHonorarios() {
//        return honorarios;
//    }
//
//    public void setHonorarios(double honorarios) {
//        this.honorarios = honorarios;
//    }
//
//    public double getTimbres() {
//        return timbres;
//    }
//
//    public void setTimbres(double timbres) {
//        this.timbres = timbres;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
}