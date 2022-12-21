package modelo;

public class Categoria {
    //Variables
    private int idCategoria;
    private String NombreCat;
    private String DescripcionCat;
    
    //Constructor
    public Categoria(){}
    
    //Getter
    public int getIdCategoria()   {return idCategoria;}
    public String getNombreCat()     {return NombreCat;}
    public String getDescripcionCat(){return DescripcionCat;}
    
    //Setter
    public void setIdCategoria(int idCategoria)      {this.idCategoria = idCategoria;}
    public void setNombreCat(String NombreCat)          {this.NombreCat = NombreCat;}
    public void setDescripcionCat(String DescripcionCat){this.DescripcionCat = DescripcionCat;}
    
}
