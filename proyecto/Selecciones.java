import greenfoot.*;
/**
 * Permite seleccionar 1 de 2 opciones de unidades para que puedas utilizarla, la bandera sirve 
 * para que se borren al momento de elegir la unidad deseada.
 */
public class Selecciones extends Mira
{
    private int visualizar;
    public Selecciones()
    {
        visualizar=0;
    }
   
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(!Greenfoot.mouseClicked(this)&&visualizar==0)
        {
            getWorld().addObject(new Buldier(),getX()-30,getY()-20);
            getWorld().addObject(new Bomba(),getX()+30,getY()+20);
            visualizar=1;
            
        }
        if(Greenfoot.mouseClicked(this)&&mouse.getX()>getX()&&mouse.getY()<getY())
        {
            removeTouching(Bomba.class);
            getWorld().addObject(new Buldier(),getX()-20,getY()-20);
            visualizar=2;
        }
        if(Greenfoot.mouseClicked(this)&&mouse.getX()>getX()+10&&mouse.getY()<getY()+10)
        {
            removeTouching(Buldier.class);
            getWorld().addObject(new Bomba(),getX()+20,getY()+20);
            visualizar=2;
            
        }
        
        
    }
    
}