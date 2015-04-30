import greenfoot.*;

public class MiniSelecciones extends Minibase
{
    private int r;
    private int s;
    private int band;
    private int borra;
    public MiniSelecciones()
    {
        band=0;
        borra=0;
    }
   
    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(!Greenfoot.mouseClicked(this)&&band==0)
        {
            getWorld().addObject(new Guerrero2(),getX()-30,getY()-20);
            getWorld().addObject(new Guerreros(),getX()+40,getY()+30);
            band=1;
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()&&m.getY()<getY())//&&setImage("bu.png"))
        {
            removeTouching(Guerrero2.class);
            getWorld().addObject(new Guerrero2(),getX()-20,getY()-20);
            //removeTouching(Guerreros.class);
        }
        if(Greenfoot.mouseClicked(this)&&m.getX()>getX()+10&&m.getY()<getY()+10)//&&setImage("bu.png"))
        {
            removeTouching(Guerreros.class);
            getWorld().addObject(new Guerreros(),getX()+20,getY()+20);
            borra=2;
        }
        
    }
}
