import greenfoot.*;
/**
 * Solo muestra en el mundo en que posición esta el indicador de nivel
 */
public class Nivel extends Actor
{
    private World w;
    public Nivel()
    {  
        
    }
    
    public void act() 
    {
        getWorld().showText("Nivel",500,10);
        
    }
    
}
