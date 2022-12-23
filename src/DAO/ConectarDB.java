package DAO;

import Formato.Mensajes;
import java.io.FileInputStream;
import java.sql.*;

public class ConectarDB implements Parametros{
    Connection con;
    Statement st;
    ResultSet rs;
    FileInputStream fi;
    PreparedStatement ps;
    ResultSetMetaData mdata;
    public ConectarDB(){
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(RUTA,USUARIO,CLAVE);
            st=con.createStatement();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede conectar a la db..."+e);
        }
    }
}
