import greenfoot.*;

/**
 * Write a description of class ComoJugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComoJugar extends World
{

    /**
     * Constructor for objects of class ComoJugar.
     * 
     */
    public ComoJugar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 700, 1); 
        Back bp=new Back();
        addObject(bp,400,650);
    }
}
