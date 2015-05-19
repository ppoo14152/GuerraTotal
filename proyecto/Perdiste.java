import greenfoot.*;
/**
 * Hace que te salga un letrero que te indica que perdiste y te regresa al menu.
 */
public class Perdiste extends World
{

    
    public Perdiste()
    {
        super(800, 700, 1); 
        Back bp=new Back();
        addObject(bp,400,650);
        GreenfootSound music=new GreenfootSound("explosion.mp3");
        music.play();
        music.setVolume(50);
    }
    
}
