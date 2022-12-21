package modelo;

public class Producto {
    //Variables
    private String idProducto;
    private String NombreProd;
    private double precioProd;
    private int stockProd;
    private String idCategoria;
    
    //Constructor
    public Producto(){}
    
    //Getter
    public String getIdProducto() {return idProducto;}
    public String getNombre()     {return NombreProd;}
    public double getPrecio()     {return precioProd;}
    public int getStock()         {return stockProd;}
    public String getIdCategoria(){return idCategoria;}
    
    //Setter
    public void setIdProducto(String idProducto)  {this.idProducto = idProducto;}
    public void setNombre(String NombreProd)      {this.NombreProd = NombreProd;}
    public void setPrecio(double precioProd)      {this.precioProd = precioProd;}
    public void setStock(int stockProd)           {this.stockProd = stockProd;}
    public void setIdCategoria(String idCategoria){this.idCategoria = idCategoria;}
    
}
