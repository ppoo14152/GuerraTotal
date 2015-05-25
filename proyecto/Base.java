import greenfoot.*;
/**
 * Al tocarla te permite poder seleccionar entre un buldier y la bomba
 */
public class Base extends Mira
{
    
    private int cantUnidades;
    private int cantiUnida;
    
    public Base()
    {
       
        cantUnidades=Greenfoot.getRandomNumber(4);
        cantiUnida=0;
    }
   
    public void act() 
    {
         
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new Selecciones(),getX(),getY());
        }
    }
    
   
}
  

