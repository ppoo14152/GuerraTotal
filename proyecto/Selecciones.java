import greenfoot.*;
/**
 * Permite seleccionar 1 de 2 opciones de unidades para que puedas utilizarla, la bandera sirve 
 * para que se borren al momento de elegir la unidad deseada.
 */

public class Selecciones extends Mira
{
    private int band;
    public Selecciones()
    {
        band=0;
    }
   /**
    * Al momento de elegir borra la otra opcion y te hace el objeto.
    */
    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        if(!Greenfoot.mouseClicked(this)&&band==0)
        {
            getWorld().addObject(new Buldier(),getX()-30,getY()-20);
            getWorld().addObject(new Bomba(),getX()+30,getY()+20);
            band=1;
            
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()&&m.getY()<getY())
        {
            removeTouching(Bomba.class);
            getWorld().addObject(new Buldier(),getX()-20,getY()-20);
           band=2;
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()+10&&m.getY()<getY()+10)
        {
            removeTouching(Buldier.class);
            getWorld().addObject(new Bomba(),getX()+20,getY()+20);
            band=2;
            
        }
        
        
    }
    
}