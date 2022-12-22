/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import VIsta.*;
import Controlador.*;
public class Main {

    public static FormMenu fm;
    public static ControladorMenu controlfm;
    
    public static FormCliente fc;
    public static ControladorCliente controlfc;
    
    public static void main(String[] args) {
        fm=new FormMenu();
        controlfm=new ControladorMenu(fm);
    }
    
}
