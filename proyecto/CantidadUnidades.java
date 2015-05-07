import greenfoot.*;

public class CantidadUnidades extends Actor
{
    private int cont;
    
    public CantidadUnidades()
    {
        cont=0;
    }
    
    public void act() 
    {
        getWorld().showText("Unidades",250,10);
        unidad();
    }
    
    public void unidad()
    {
        cont+=0;
        getWorld().showText(""+cont,250,50);
        
    }
}
