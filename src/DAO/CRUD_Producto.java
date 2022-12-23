package DAO;

import Formato.ManejadorTablas;
import Formato.Mensajes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class CRUD_Producto extends ConectarDB{
    public void MostrarClientesEnTabla(JTable tabla){
        String[] titulos={"Nro","ID","NOMBRE","PRECIO","STOCK","IDCATEGORIA"};
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
            }
            ManejadorTablas.FormatoTablaCliente(tabla);
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR Al obtener la tabla de Producto -->"+e);
        }
    }
}
