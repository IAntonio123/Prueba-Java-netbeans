/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUD_Cliente;
import VIsta.*;
import modelo.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCliente implements ActionListener{
    FormCliente vista;
    Cliente model;
    CRUD_Cliente crud;
    public ControladorCliente(FormCliente fc){
        vista=fc;
        vista.btnRegistrar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        ProcesosCliente.Presentacion(fc);
        AcualizarForm();
    }
    void AcualizarForm(){
        crud=new CRUD_Cliente();
        crud.MostrarClientesEnTabla(vista.tblCliente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){
            
        }
    }
    
}
