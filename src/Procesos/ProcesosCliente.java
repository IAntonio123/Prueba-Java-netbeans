package Procesos;

import VIsta.FormCliente;
import modelo.Cliente;

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
