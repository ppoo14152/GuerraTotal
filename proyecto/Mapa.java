import greenfoot.*;

public class Mapa extends World
{
    public int x;
    public int y;
    public Mapa()
    {    
       super(800, 600, 1); 
       x=50;
       y=50;
       Mira m=new Mira();
       addObject(m,400,300);
       Base b=new Base();
       addObject(b,x,y);
       Enemigo e=new Enemigo();
       addObject(e,100,400);
       Enemigo s=new Enemigo();
       addObject(s,400,400);
      
    }
}