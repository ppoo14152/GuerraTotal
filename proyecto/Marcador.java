import greenfoot.*;  
/**
 * Muestra la imagen de del cuadro de los records y una que te permite regresar al menu.
 */
public class Marcador extends World
{
    
    
    public Marcador() 
    { 
        super(800, 700, 1); 
        
        ScoreBoard bp=new ScoreBoard(300,350);
        addObject(bp,400,300);
        
        Back s=new Back();
        addObject(s,400,650);
    }
    
}
