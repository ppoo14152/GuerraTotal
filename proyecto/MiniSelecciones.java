import greenfoot.*;
/**
 * Permite seleccionar 1 de 2 opciones de unidades para que puedas utilizarla, la bandera sirve 
 * para que se borren al momento de elegir la unidad deseada.
 */
public class MiniSelecciones extends Minibase
{
    
    private int alSeleccionar;
    private int borra;
    public MiniSelecciones()
    {
        alSeleccionar=0;
        borra=0;
    }
   
    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(!Greenfoot.mouseClicked(this)&&alSeleccionar==0)
        {
            getWorld().addObject(new Guerrero2(),getX()-30,getY()-20);
            getWorld().addObject(new Guerreros(),getX()+40,getY()+30);
            alSeleccionar=1;
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()&&m.getY()<getY())
        {
            removeTouching(Guerrero2.class);
            getWorld().addObject(new Guerrero2(),getX()-20,getY()-20);
            borra=2;
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()+10&&m.getY()<getY()+10)
        {
            removeTouching(Guerreros.class);
            getWorld().addObject(new Guerreros(),getX()+20,getY()+20);
            borra=2;
        }
        
    }
}
