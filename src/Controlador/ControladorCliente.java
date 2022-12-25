package Controlador;

import DAO.CRUD_Cliente;
import Formato.Mensajes;
import VIsta.*;
import modelo.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorCliente implements ActionListener{
    FormCliente vista;
    Cliente model;
    CRUD_Cliente crud;
    
    public ControladorCliente(FormCliente fc){
        vista=fc;
        vista.btnRegistrar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        ProcesosCliente.Presentacion(fc);
        AcualizarForm();
    }
    void AcualizarForm(){
        crud=new CRUD_Cliente();
        crud.MostrarClientesEnTabla(vista.tblCliente);
        ProcesosCliente.LimpiarEntradas(vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){
            model=ProcesosCliente.LeerDatos(vista);
            crud=new CRUD_Cliente();
            crud.InsertarCLiente(model);
            AcualizarForm();
            
        }
        
        
        if(e.getSource()==vista.btnConsultar){
            int codigo=Mensajes.M2("Ingrese el Codigo de la Mascota");
            crud=new CRUD_Cliente();
            model=crud.RecuperarDatosdeServicio(codigo);
            if(model==null){
                Mensajes.M1("El ID CLIENTE : "+codigo+" no existe en la DB");
            }else{
                vista.txtNombres.setText(model.getNombres());
                vista.txtApellidos.setText(model.getApellidos());
                vista.txtDireccion.setText(model.getDireccion());
                SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
                Date fechatxt;
                try {
                    fechatxt=df.parse(model.getFechaNac()+"");
                    vista.jdcFechaNacimiento.setDate(fechatxt);
                } catch (ParseException ex) {
                    Mensajes.M1("No se puedo obtener un dato "+ex);
                }
                vista.txtTelefono.setText(model.getTelefono());
                vista.txtEmail.setText(model.getEmail());
                vista.txtIdCliente.setText(model.getIdCliente()+"");
                vista.txtNombres.requestFocus();
            }
        }
        
        
        if(e.getSource()==vista.btnActualizar){
           model=ProcesosCliente.LeerDatos(vista);
           model.setIdCliente(Integer.parseInt(vista.txtIdCliente.getText()));
           crud=new CRUD_Cliente();
           crud.ActualizarCliente(model);
           AcualizarForm();
       }
    }
    
}
