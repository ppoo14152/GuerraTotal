import greenfoot.*;
/**
 * Al momento de tocarla y hacerle click esta nos llevara a otro cuadro que nos indica como jugar
 */

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
