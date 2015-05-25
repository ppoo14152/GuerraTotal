import greenfoot.*;
/**
 * En el se encuentra el nombre del juego jugar, records y ayuda a las cuales puedes 
 * acceder al seleccionarlas
 */
public class Menu extends World
{
    public Menu()
    {    
        super(800, 600, 1); 
        BotonPlay bp=new BotonPlay();
        addObject(bp,150,200);
        Ayuda ay=new Ayuda();
        addObject(ay,150,400);
        Total t=new Total();
        addObject(t,500,200);
        Records re=new Records();
        addObject(re,400,500);
        
        
    }
}