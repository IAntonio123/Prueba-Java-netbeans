package DAO;

import Formato.ManejadorTablas;
import Formato.Mensajes;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

public class CRUD_Cliente extends ConectarDB{
    public void MostrarClientesEnTabla(JTable tabla){
        String[] titulos={"Nro","ID","NOMBRES","APELLIDOS","DIRECCION","FEC. NACIMIENTO","TELEFONO","EMAIL"};
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        Cliente cli=new Cliente();
        int cantreg=0;
        try {
            
            rs =st.executeQuery("select * from railway.Cliente;");
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
            Mensajes.M1("ERROR Al obtener la tabla de Cliente -->"+e);
        }
    }
    public void InsertarCLiente(Cliente cli){
         try {
            SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
            ps=con.prepareStatement("insert into railway.Cliente(nombre,apellido,direccion,fechaNacimiento,telefono,email)" +
                                    " values(?,?,?,?,?,?);");
            ps.setString(1, cli.getNombres());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getDireccion());
            ps.setString(4,df.format(cli.getFechaNac()));
            ps.setString(5, cli.getTelefono());
            ps.setString(6, cli.getEmail());
            ps.executeUpdate();
            Mensajes.M1("Datos del Cliente : "+cli.getNombres()+" "+cli.getApellidos()+" registrados Correcatamente");
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al guardar datos en la Cliente -->"+e);
        }
    }
    public Cliente RecuperarDatosdeServicio(int idCliente){
        Cliente cli=null;
        try {
            rs=st.executeQuery("select * from railway.Cliente c where c.idCliente="+idCliente+";");
            if(rs.next()){
                cli=new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setFechaNac(rs.getDate(5));
                cli.setTelefono(rs.getString(6));
                cli.setEmail(rs.getString(7));
                
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("Error no se puede recuperar datos del Id Cliente = "+idCliente+"   "+e);
        }
        return cli;
    }
    
    public void ActualizarCliente(Cliente cli){
        try {
            SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
            ps=con.prepareStatement("update railway.Cliente p set p.nombre=?,p.apellido=?,p.direccion=?,p.fechaNacimiento=?,p.telefono=?,p.email=?" +
                                    " where p.idCliente=?;");
            ps.setString(1, cli.getNombres());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getDireccion());
            ps.setString(4,df.format(cli.getFechaNac()));
            ps.setString(5, cli.getTelefono());
            ps.setString(6, cli.getEmail());
            ps.setInt(7, cli.getIdCliente());
            ps.executeUpdate();
            Mensajes.M1("Datos del Cliente : "+cli.getNombres()+" "+cli.getApellidos()+" se Actualizaron Correctamente");
            con.close();
        } catch (Exception e) {
            Mensajes.M1("Error a la hora de Actualizar Datos del Cliente: "+cli.getNombres()+" "+cli.getApellidos()+"   \n"+e); 
        }
    }
}
