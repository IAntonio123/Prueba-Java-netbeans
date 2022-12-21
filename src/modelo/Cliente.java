package modelo;

import java.util.Date;

public class Cliente {
    //Variables
    private String idCliente;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date fechaNac;
    private String telefono;
    private String Email;
    
    //Constructor
    public Cliente(){}
    
    //Getter
    public String getIdCliente(){return idCliente;}
    public String getNombres()  {return nombres;}
    public String getApellidos(){return apellidos;}
    public String getDireccion(){return direccion;}
    public Date getFechaNac()   {return fechaNac;}
    public String getTelefono() {return telefono;}
    public String getEmail()    {return Email;}
    
    //Setter
    public void setIdCliente(String idCliente){this.idCliente = idCliente;}
    public void setNombres(String nombres)    {this.nombres = nombres;}
    public void setApellidos(String apellidos){this.apellidos = apellidos;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public void setFechaNac(Date fechaNac)    {this.fechaNac = fechaNac;}
    public void setTelefono(String telefono)  {this.telefono = telefono;}
    public void setEmail(String Email)        {this.Email = Email;}
    
}