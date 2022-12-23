package Formato;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {
    
    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   //metodo que la da formato a la JTable del tabla Categorias
   public static void FormatoTablaCliente(JTable tabla){
       
       AnchoColumnas(tabla,0,50);
       AnchoColumnas(tabla,1,80);
       AnchoColumnas(tabla,2,200);
       AnchoColumnas(tabla,3,200);
       AnchoColumnas(tabla,4,200); 
       AnchoColumnas(tabla,5,100);
       AnchoColumnas(tabla,6,100);
       AnchoColumnas(tabla,7,150);
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,5);
   }
   
}
