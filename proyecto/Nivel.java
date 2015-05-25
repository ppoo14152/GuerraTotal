import greenfoot.*;
/**
 * Solo muestra en el mundo en que posición esta el indicador de nivel
 */
public class Nivel extends Actor
{
    private int nivel;
    private World w;
    public Nivel()
    {
        nivel=1;
        
    }
    
    public void act() 
    {
        getWorld().showText("Nivel",500,10);
        
    }
    
}
