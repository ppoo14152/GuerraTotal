import greenfoot.*;


public class BotonPlay extends Actor
{
    private World w;
    public BotonPlay()
    {
        
        w=getWorld();
    }
    
    public void act() 
    {
        otroMundo();
    }  
   
    public void otroMundo()
    {
        if(Greenfoot.mouseClicked(this))
        {
            w=new Mapa();
            Greenfoot.setWorld(w);
        } 
    }


}
