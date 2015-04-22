import greenfoot.*;

public class Mapa1 extends World
{
    public int x;
    public int y;
    public Mapa1()
    {    
       super(800, 600, 1); 
       Mira m=new Mira();
       addObject(m,1,1);
       Base b=new Base();
       addObject(b,500,300);
    }
}
