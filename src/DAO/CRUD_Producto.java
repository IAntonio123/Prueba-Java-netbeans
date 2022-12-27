package DAO;

import Formato.ManejadorTablas;
import Formato.Mensajes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class CRUD_Producto extends ConectarDB{
    public void MostrarProductosEnTabla(JTable tabla){
        String[] titulos={"N°","ID","NOMBRE","PRECIO","STOCK","IDCATEGORIA"};
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        Producto pro=new Producto();
        int cantreg=0;
        try {
            
            rs =st.executeQuery("select * from railway.Producto;");
            while(rs.next()){
                cantreg++;
                pro.setIdProducto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setIdCategoria(rs.getInt(5));
                modelo.addRow(pro.Registo(cantreg));
            }
            ManejadorTablas.FormatoTablaProducto(tabla);
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR Al obtener la tabla de Producto -->"+e);
        }
    }
    
    public void InsertarProducto(Producto pro){
         try {
            ps=con.prepareStatement("insert into railway.Producto(idProducto,nombre,precio,stock,idCategoria)" +
                                    " values(?,?,?,?,?);");
            ps.setInt(1, pro.getIdProducto());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4,pro.getStock());
            ps.setInt(5, pro.getIdCategoria());
            ps.executeUpdate();
            Mensajes.M1("Datos del Producto: "+pro.getNombre()+" "+" se registró Correcatamente");
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al guardar datos en la Producto -->"+e);
        }
    }
    public Producto RecuperarDatosdeServicio(int idProducto){
        Producto pro=null;
        try {
            rs=st.executeQuery("select * from railway.Producto c where c.idProducto = "+idProducto+";");
            if(rs.next()){
                pro=new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setIdCategoria(rs.getInt(5));
                
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("Error no se puede recuperar datos del Id Producto = "+idProducto+"  "+e);
        }
        return pro;
    }
    
    public void ActualizarProducto(Producto pro){

        try {
            ps=con.prepareStatement("update railway.Producto p set p.nombre=?,p.precio=?,p.stock=?,p.idCategoria=?" +
                                    " where p.idProducto=?;");
            ps.setString(1, pro.getNombre());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt   (3, pro.getStock());
            ps.setInt   (4, pro.getIdCategoria());
            ps.setInt   (5, pro.getIdProducto());
            ps.executeUpdate();
            Mensajes.M1("Datos del Producto : "+pro.getNombre()+" se Actualizaron Correctamente");
            con.close();
        } catch (Exception e) {
            Mensajes.M1("Error a la hora de Actualizar Datos del Producto: "+pro.getNombre()+"   \n"+e); 
        }
    }
}
