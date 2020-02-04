package com.javier.componente;

import java.time.LocalDate;

public class Tarea {

    private int horas;
    private int minutos;
    private int segundos;
    private String textoAlarma;

    public Tarea (int horas, int minutos, int segundos, String textoAlarma){
        this.horas=horas;
        this.minutos=minutos;
        this.segundos=segundos;
        this.textoAlarma=textoAlarma;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getTextoAlarma() {
        return textoAlarma;
    }

    public void setTextoAlarma(String textoAlarma) {
        this.textoAlarma = textoAlarma;
    }
}
