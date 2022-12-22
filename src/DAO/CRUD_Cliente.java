/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Formato.ManejadorTablas;
import Formato.Mensajes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author Antonio
 */
public class CRUD_Cliente extends ConectarDB{
    public void MostrarClientesEnTabla(JTable tabla){
        String[] titulos={"Nro","ID","NOMBRES","APELLIDOS","DIRECCION","FEC. NACIMIENTO","TELEFONO","EMAIL"};
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        Cliente cli=new Cliente();
        int cantreg=0;
        try {
            
            rs =st.executeQuery("select * from Cliente;");
            while(rs.next()){
                cantreg++;
                cli.setIdCliente(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setFechaNac(rs.getDate(5));
                cli.setTelefono(rs.getString(6));
                cli.setEmail(rs.getString(7));
                modelo.addRow(cli.Registo(cantreg));
            }
            ManejadorTablas.FormatoTablaCliente(tabla);
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR Al obtener la tabla de PROPIETARIOS -->"+e);
        }
    }
}
