package Controlador;

import DAO.CRUD_Producto;
import Formato.Mensajes;
import VIsta.*;
import modelo.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorProducto implements ActionListener{
    FormProducto vista;
    Producto model;
    CRUD_Producto crud;
    
    public ControladorProducto(FormProducto pro){
        vista=pro;
        vista.jbtnRegistrar.addActionListener(this);
        vista.jbtnBuscar.addActionListener(this);
        vista.jbtnActualizar.addActionListener(this);
        ProcesosProducto.Presentacion(pro);
        AcualizarForm();
    }
    void AcualizarForm(){
        crud=new CRUD_Producto();
        crud.MostrarProductosEnTabla(vista.jtblDatos);
        ProcesosProducto.LimpiarEntradas(vista);
        ProcesosProducto.CompletarCombos(vista);
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnRegistrar){
            
            model=ProcesosProducto.LeerDatos(vista);
            crud=new CRUD_Producto();
            crud.InsertarProducto(model);
            AcualizarForm();
            
        }

        
        if(e.getSource()==vista.jbtnBuscar){
        
            int codigo=Mensajes.M2("Ingrese el ID del Producto");
            crud=new CRUD_Producto();
            model=crud.RecuperarDatosdeServicio(codigo);
            if(model==null){
                Mensajes.M1("El ID del Producto: "+codigo+" no existe en el DataBase");
            }else{
                vista.jtxtNombreProd.setText(model.getNombre());
                vista.jtxtPrecio.setText(model.getPrecio()+"");
                vista.jtxtStock.setText(model.getStock()+"");
                vista.jtxtIdProducto.setText(model.getIdProducto()+"");
                vista.jcbxCategoria.setSelectedItem(model.getIdCategoria());
            }
            
        }
        
        if(e.getSource()==vista.jbtnActualizar){
        
           model=ProcesosProducto.LeerDatos(vista);
           model.setIdProducto(Integer.parseInt(vista.jtxtIdProducto.getText()));
           crud=new CRUD_Producto();
           crud.ActualizarProducto(model);
           AcualizarForm();
            
        }
    }
}
