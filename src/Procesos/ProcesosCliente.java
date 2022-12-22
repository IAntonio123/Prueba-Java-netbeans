/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import VIsta.FormCliente;
import modelo.Cliente;

/**
 *
 * @author Antonio
 */
public class ProcesosCliente {
    public static void Presentacion(FormCliente fc){
    fc.setTitle("Formulario de los Veterinarios");
    fc.txtIdCliente.setEnabled(false);
    fc.setVisible(true);
}
   
    
    public static Cliente LeerDatos(FormCliente fc){
        Cliente cli=new Cliente();
        cli.setNombres(fc.txtNombres.getText());
        cli.setApellidos(fc.txtApellidos.getText());
        cli.setDireccion(fc.txtDireccion.getText());
        cli.setFechaNac(fc.jdcFechaNacimiento.getDate());
        cli.setTelefono(fc.txtTelefono.getText());
        cli.setEmail(fc.txtEmail.getText());
        return cli;
    }
}
