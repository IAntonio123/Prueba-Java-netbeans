package Controlador;

import DAO.CRUD_Producto;
import VIsta.*;
import modelo.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorProducto implements ActionListener{
    FormProducto Vista;
    Producto model;
    CRUD_Producto crud;
    public ControladorProducto(FormProducto pro){
        Vista=pro;
        Vista.jbtnRegistrar.addActionListener(this);
        Vista.jbtnBuscar.addActionListener(this);
        Vista.jbtnBuscar.addActionListener(this);
        ProcesosProducto.Presentacion(pro);
        AcualizarForm();
    }
    void AcualizarForm(){
        crud=new CRUD_Producto();
        crud.MostrarClientesEnTabla(Vista.jtblDatos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Vista.jbtnRegistrar){
            
        }
    }
    
}
