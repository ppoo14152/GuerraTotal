import greenfoot.*;

public class Base extends Mira
{
    private int daDinero;
    private int cantUnidades;
    private int cantiUnida;
    private int acumulaDinero;
    public Base()
    {
        daDinero=Greenfoot.getRandomNumber(4);
        cantUnidades=Greenfoot.getRandomNumber(4);
        cantiUnida=0;
        daDinero=0;
        acumulaDinero=0;
    }
   
    public void act() 
    {
        
         recurso();
         Unidades();
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new Selecciones(),getX(),getY());
        }
    }
    
    public void recurso()
    {
       
        if(daDinero==2)
           acumulaDinero+=10;
        getWorld().showText(""+acumulaDinero,100,50);
    }
    
    public void Unidades()
    {
        
        if(cantUnidades==2)
           cantiUnida+=1;
        getWorld().showText(""+cantiUnida,250,50);
    }
}
  

