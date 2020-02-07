package com.javier.test;

import com.javier.componente.ComponenteReloj;
import com.javier.componente.EnHoraQueCoincide;
import com.javier.componente.Tarea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class Prueba extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox=new VBox();
        ComponenteReloj cp=new ComponenteReloj();
        //Tarea tarea = new Tarea(2, 19, 25 , "pruebaAlarma");
        cp.setFormato24h(false);
        //cp.registarTarea(tarea);
        cp.addEnHoraQueCoincide(new EnHoraQueCoincide() {
            @Override
            public void ejecuta(Tarea tarea) {
                System.out.println("Acuerdate de comprar pan");
            }
        });

        cp.addEnHoraQueCoincide(new EnHoraQueCoincide() {
            @Override
            public void ejecuta(Tarea tarea) {
                System.out.println("Y leche tambien!");
            }
        });

        vBox.getChildren().add(cp);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        cp.iniciar();
    }

    public static void main (String[] args){
        launch(args);
    }
}
