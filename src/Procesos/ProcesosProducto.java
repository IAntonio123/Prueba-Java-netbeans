package Procesos;

import VIsta.FormProducto;
import modelo.Producto;

public class ProcesosProducto {
    public static void Presentacion(FormProducto fp){
    fp.setTitle("Formulario de Productos");
    fp.jtxtIdProducto.setEnabled(false);
    fp.jtxtIdCategoria.setEnabled(false);
    fp.setVisible(true);
    }
   
    public static void LimpiarEntradas(FormProducto fp){
        fp.jtxtIdProducto.setText("");
        fp.jtxtIdCategoria.setText("");
        fp.jtxtNombreProd.setText("");
        fp.jtxtPrecio.setText("");
        fp.jtxtStock.setText("");
    }
    
    public static Producto LeerDatos(FormProducto fp){
        Producto pro=new Producto();
        pro.setNombre(fp.jtxtNombreProd.getText());
        pro.setPrecio(Double.valueOf(fp.jtxtPrecio.getText()));
        pro.setStock(Integer.parseInt(fp.jtxtStock.getText()));
        return pro;
    }
}
