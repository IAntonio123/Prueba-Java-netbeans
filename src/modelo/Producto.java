package modelo;

public class Producto {
    //Variables
    private int idProducto;
    private String NombreProd;
    private double precioProd;
    private int stockProd;
    private int idCategoria;
    
    //Constructor
    public Producto(){}
    
    //Getter
    public int getIdProducto() {return idProducto;}
    public String getNombre()     {return NombreProd;}
    public double getPrecio()     {return precioProd;}
    public int getStock()         {return stockProd;}
    public int getIdCategoria(){return idCategoria;}
    
    //Setter
    public void setIdProducto(int idProducto)  {this.idProducto = idProducto;}
    public void setNombre(String NombreProd)      {this.NombreProd = NombreProd;}
    public void setPrecio(double precioProd)      {this.precioProd = precioProd;}
    public void setStock(int stockProd)           {this.stockProd = stockProd;}
    public void setIdCategoria(int idCategoria){this.idCategoria = idCategoria;}
    
    //Object data
    public Object[] Registo(int num){
        Object[] fila={num,idProducto,NombreProd,precioProd,stockProd,idCategoria};
        return fila;
    }
}
