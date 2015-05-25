import greenfoot.*;

/**
 * Write a description of class Ganaste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ganaste extends World
{
    private World w;
    /**
     * Constructor for objects of class Ganaste.
     * 
     */
    public Ganaste()
    {    
        super(800, 700, 1); 
        
        
        GreenfootSound music=new GreenfootSound("explosion.mp3");
        music.play();
        music.setVolume(50);
    }
    
}
