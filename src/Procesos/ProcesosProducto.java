package Procesos;

import VIsta.FormProducto;
import modelo.*;

public class ProcesosProducto implements ListasCategoria{
    public static void Presentacion(FormProducto fp){
    fp.setTitle("Formulario de Productos");
    fp.jtxtIdProducto.setEnabled(false);
    fp.setVisible(true);
    }
   
    public static void LimpiarEntradas(FormProducto fp){
        fp.jtxtIdProducto.setText("");
        fp.jcbxCategoria.setSelectedIndex(0);
        fp.jtxtNombreProd.setText("");
        fp.jtxtPrecio.setText("");
        fp.jtxtStock.setText("");
    }
    
    public static Producto LeerDatos(FormProducto fp){
        Producto pro=new Producto();
        pro.setNombre(fp.jtxtNombreProd.getText());
        pro.setPrecio(Double.valueOf(fp.jtxtPrecio.getText()));
        pro.setStock(Integer.parseInt(fp.jtxtStock.getText()));
        pro.setIdCategoria(Integer.parseInt(fp.jcbxCategoria.getSelectedItem().toString()));
        return pro;
    }
    
    public static void CompletarCombos(FormProducto pro){
    
        pro.jcbxCategoria.removeAllItems();
        
        for (int i = 0; i < LISTACATEGORIA.length; i++) {
            
            pro.jcbxCategoria.addItem(String.valueOf((LISTACATEGORIA[i])));
            
        }
        
    }
}
