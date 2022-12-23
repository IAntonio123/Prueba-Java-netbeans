package Controlador;

import Formato.*;
import Principal.Main;
import VIsta.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorMenu implements ActionListener{
    FormMenu vista;
    public ControladorMenu(FormMenu fm){
        vista=fm;
        vista.itemMCliente.addActionListener(this);
        vista.itemMProducto.addActionListener(this);
        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
        fm.setVisible(true);
        fm.setTitle("Venta de Productos");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.itemMCliente){
            Main.fc=new FormCliente();
            Main.controlfc=new ControladorCliente(Main.fc);
            vista.jdpnContenedor.add(Main.fc);
            CentrarForma.CPanel(vista.jdpnContenedor, Main.fc);
        }
        
        if(e.getSource()==vista.itemMProducto){
            Main.fp=new FormProducto();
            Main.controlfp=new ControladorProducto(Main.fp);
            vista.jdpnContenedor.add(Main.fp);
            CentrarForma.CPanel(vista.jdpnContenedor, Main.fp);
        }
            
    }
}
