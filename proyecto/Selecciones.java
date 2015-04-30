import greenfoot.*;

public class Selecciones extends Base
{
    private int r;
    private int s;
    private int band;
    private int borra;
    private int x;
    private int y;
    public Selecciones()
    {
        band=0;
        borra=0;
        x=0;
        y=0;
    }
   
    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(!Greenfoot.mouseClicked(this)&&band==0)
        {
            getWorld().addObject(new Buldier(),getX()-30,getY()-20);
            band=1;
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()&&m.getY()<getY())
        {
            removeTouching(Guerreros.class);
            getWorld().addObject(new Buldier(),getX()-20,getY()-20);
           
        }
        /*if(Greenfoot.mouseClicked(this)&&m.getX()>getX()+10&&m.getY()<getY()+10)//&&setImage("bu.png"))
        {
            removeTouching(Guerreros.class);
            getWorld().addObject(new Guerreros(),getX()+20,getY()+20);
            borra=2;
            
        }*/
        
        
    }
}