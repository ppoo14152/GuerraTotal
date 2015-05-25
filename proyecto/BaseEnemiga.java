import greenfoot.*;
/**
 * Al momento de que la seleccionas hace que aleatoriamente se elija uno de 2 soldados para que apare-
 * scan en el mapa, s y r son para que aparescan en diferentes coordenadas
 */
public class BaseEnemiga extends Mira
{
    private int r;
    private int s;
    private int band;
    private int limite;
    public BaseEnemiga()
    {
        band=0;
        limite=0;
    }
   /**
    * Crea a los soldados.
    */
    public void act() 
    {
        if(Greenfoot.getRandomNumber(150)==5)
        {
            int r=Greenfoot.getRandomNumber(100);
            int s=Greenfoot.getRandomNumber(100);
            
                
                if(Greenfoot.getRandomNumber(3)==2)
                getWorld().addObject(new BuldierEnemigo(),getX()-r,getY()+s);
                if(Greenfoot.getRandomNumber(3)==1)
                getWorld().addObject(new BombaEnemiga(),getX()-r,getY()+s);
            
        }
    }
}