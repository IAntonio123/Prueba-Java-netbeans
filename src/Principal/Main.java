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
