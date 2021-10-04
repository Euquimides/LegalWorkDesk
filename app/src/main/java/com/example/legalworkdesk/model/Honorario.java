package com.example.legalworkdesk.model;

import java.io.Serializable;

public class Honorario implements Serializable {

        private String nombreProceso;
        private long monto;
        private long timbre;

        public Honorario (){}

    public Honorario(String nombreProceso, long monto, long timbre) {
        this.nombreProceso = nombreProceso;
        this.monto = monto;
        this.timbre = timbre;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public long getTimbre() {
        return timbre;
    }

    public void setTimbre(long timbre) {
        this.timbre = timbre;
    }
}