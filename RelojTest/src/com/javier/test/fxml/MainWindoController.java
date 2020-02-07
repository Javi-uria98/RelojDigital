package com.javier.test.fxml;

import com.javier.componente.ComponenteReloj;
import com.javier.componente.EnHoraQueCoincide;
import com.javier.componente.Tarea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindoController implements Initializable {

    @FXML
    private ComponenteReloj cp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tarea tarea=new Tarea(2, 24, 20, "Alarma comprar pan");
        Tarea tarea2=new Tarea(2, 24, 25, "Alarma comprar leche");
        cp.registarTarea(tarea);
        cp.registarTarea(tarea2);
        cp.borrarTarea(tarea);
        cp.addEnHoraQueCoincide(new EnHoraQueCoincide() {
            @Override
            public void ejecuta(Tarea tarea) {
                System.out.println("Se ejecuta el listener");
            }
        });
        cp.iniciar();
    }
}
