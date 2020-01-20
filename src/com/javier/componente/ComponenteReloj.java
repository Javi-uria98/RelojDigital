package com.javier.componente;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ComponenteReloj extends Label {

    private IntegerProperty minutos;
    private IntegerProperty horas;

    public ComponenteReloj() {
        super();
    }

    public ComponenteReloj(String s) {
        super(s);
    }

    public ComponenteReloj(String s, Node node) {
        super(s, node);
    }

    public int getMinutos() {
        return minutos.get();
    }

    public IntegerProperty minutosProperty() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos.set(minutos);
    }

    public int getHoras() {
        return horas.get();
    }

    public IntegerProperty horasProperty() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas.set(horas);
    }

    public void iniciar() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (true) {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Calendar rightNow = Calendar.getInstance();
                            int hour = rightNow.get(Calendar.HOUR_OF_DAY);

                        }
                    });

                } else {
                    timer.cancel();
                    timer.purge();
                }
            }
        }, 1000, 1000);

    }
}
