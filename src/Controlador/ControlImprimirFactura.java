
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUD_Factura;
import Formato.Mensajes;
import VIsta.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import modelo.ImprimirFactura;

/**
 *
 * @author Antonio
 */
public class ControlImprimirFactura implements ActionListener{
    FormImprimirFactura vista;
    PanelFactura pFactura;
    ImprimirFactura model;
    CRUD_Factura crud;
    public ControlImprimirFactura(FormImprimirFactura fif){
        vista=fif;
        vista.btnImprimir.addActionListener(this);
        rsscalelabel.RSScaleLabel.setScaleLabel(vista.panelFactura.lblLogo, "C:\\Users\\Antonio\\Downloads\\productos\\Prueba-Java-netbeans\\src\\Assets\\logo.png");
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnImprimir){
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.panelFactura);
            if(job.printDialog()){
                try{
                    job.print();
                }catch(PrinterException ex){
                    
                }
            }else{
                Mensajes.M1("La Impresion se Cancelo");
            }
        }
    }
}
