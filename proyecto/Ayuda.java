import greenfoot.*;


public class Ayuda extends Actor
{
    private World w;
    public Ayuda()
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
            w=new ComoJugar();
            Greenfoot.setWorld(w);
        } 
    }


}
