import greenfoot.*;
/**
 * Una imagen que permite ver cuantas unidades hay en el mapa, ese breve codigo
 * es para que no se pinte varias veces
 */
public class Malo extends MiniMapa
{
   
    public Malo()
    {
        
    }
    public void act() 
    {
           World w=getWorld();
           w.removeObject(this);
    }
}