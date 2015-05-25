import greenfoot.*;
/**
 * Coloca las imagenes del escenario en forma aleatoria
 */
public class Cosa extends Mira
{
    
    public Cosa()
    {
        int i=Greenfoot.getRandomNumber(360);
        setImage("cosa.png");
        turn(i);
    }
}

