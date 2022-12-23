package Procesos;

import VIsta.FormProducto;
import modelo.Producto;

public class ProcesosProducto {
    public static void Presentacion(FormProducto fc){
    fc.setTitle("Formulario de los Veterinarios");
    fc.jtxtIdProducto.setEnabled(false);
    fc.jtxtIdCategoria.setEnabled(false);
    fc.setVisible(true);
}
   
    
    public static Producto LeerDatos(FormProducto fc){
        Producto pro=new Producto();
        pro.setNombre(fc.jtxtNombreProd.getText());
        pro.setPrecio(Double.parseDouble(fc.jtxtPrecio.getText()));
        pro.setStock(Integer.parseInt(fc.jtxtStock.getText()));
        return pro;
    }
}
