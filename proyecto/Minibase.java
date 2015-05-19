import greenfoot.*;
/**
 * Al momento de que la seleccionas coloca una cuadro con opciones de unidades para combatir.
 */
public class Minibase extends Mira
{
    public Minibase()
    {
        
    }
   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new MiniSelecciones(),getX(),getY());
        }
        removeTouching(Buldier.class);
    }
}
  

