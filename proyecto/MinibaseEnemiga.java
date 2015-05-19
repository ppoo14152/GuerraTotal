import greenfoot.*;
/**
 * Permite que salgan enemigos aleatoriamente.
 */
public class MinibaseEnemiga extends Mira
{
    
    private int limite;
    
    public MinibaseEnemiga()
    {
       
        limite=0;
    }
   
    public void act() 
    {
        if(Greenfoot.getRandomNumber(150)==7)
        {
       
            
            if(limite!=4)
            {
                if(Greenfoot.getRandomNumber(3)==2)
                getWorld().addObject(new Enemigo(),getX(),getY());
                if(Greenfoot.getRandomNumber(3)==1)
                getWorld().addObject(new Enemigo2(),getX(),getY());
                limite++;
            }
        }
        
    }
}