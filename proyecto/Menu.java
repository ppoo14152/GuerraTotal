import greenfoot.*;

public class Menu extends World
{
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        BotonPlay bp=new BotonPlay();
        addObject(bp,100,100);
        Ayuda ay=new Ayuda();
        addObject(ay,100,250);
    }
    
    public void act()
    {
       /* BotonPlay bp=new BotonPlay();
        addObject(bp,400,300);*/
    }
}
