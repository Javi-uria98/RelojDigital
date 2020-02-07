package com.javier.componente;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.*;

public class ComponenteReloj extends Label {

    private BooleanProperty formato24h = new SimpleBooleanProperty();
    private int horas;
    private int minutos;
    private int segundos;
    private ArrayList<Tarea> listaTareas;
    private ArrayList<EnHoraQueCoincide> enHoraQueCoincide;

    public ComponenteReloj() {
        enHoraQueCoincide = new ArrayList<EnHoraQueCoincide>();
        listaTareas = new ArrayList<Tarea>();
    }

    public ComponenteReloj(String s) {
        super(s);
    }

    public ComponenteReloj(String s, Node node) {
        super(s, node);
    }

    public void addEnHoraQueCoincide(EnHoraQueCoincide enHoraQueCoincide) {
        this.enHoraQueCoincide.add(enHoraQueCoincide);
    }

    public boolean isFormato24h() {
        return formato24h.get();
    }

    public BooleanProperty formato24hProperty() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        this.formato24h.set(formato24h);
    }

    public int getHoras() {
        return horas;
    }

    /*public void setHoras(int horas) {
        this.horas = horas;
    }*/

    public int getMinutos() {
        return minutos;
    }

    /*public void setMinutos(int minutos) {
        this.minutos = minutos;
    }*/

    public int getSegundos() {
        return segundos;
    }

    /*public void setSegundos(int segundos) {
        this.segundos = segundos;
    }*/

    public void iniciar() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (true) {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ZonedDateTime now = ZonedDateTime.now();
                            horas = now.getHour();
                            minutos = now.getMinute();
                            segundos = now.getSecond();
                            DecimalFormat formatter = new DecimalFormat("00");
                            if (formato24h.get() || horas<12) {
                                setText(formatter.format(horas) + ":" + formatter.format(minutos) + ":" + formatter.format(segundos));
                            } else {
                                horas = horas - 12;
                                setText(formatter.format(horas) + ":" + formatter.format(minutos) + ":" + formatter.format(segundos));
                            }
                            if (listaTareas != null) {
                                for (Tarea tarea : listaTareas) {
                                    if (horas == tarea.getHoras() && minutos == tarea.getMinutos() && segundos == tarea.getSegundos()) {
                                        for (EnHoraQueCoincide e : enHoraQueCoincide) {
                                            e.ejecuta(tarea);
                                        }
                                    } else {
                                        if (horas == tarea.getHoras() - 12 && minutos == tarea.getMinutos() && segundos == tarea.getSegundos()) {
                                            for (EnHoraQueCoincide e : enHoraQueCoincide) {
                                                e.ejecuta(tarea);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    });

                } else {
                    timer.cancel();
                    timer.purge();
                }
            }
        }, 0, 1000);

    }

    public void registarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void borrarTarea(Tarea tarea) {
        listaTareas.remove(tarea);
    }
}
