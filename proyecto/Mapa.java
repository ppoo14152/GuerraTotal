import greenfoot.*;

public class Mapa extends ScrollWorld
{
    private int x;
    private int y;
    private int a;
    private int b;
    private int canti;
    private Base f;
    private Buldier bul;
    public Mapa()
    {    
        super(800, 600, 1, 1500,1500);
        Mapa();
       
        bul=new Buldier();

        //canti=Greenfoot.getRandomNumber(2);
    }

    public void Mapa()
    {
        a=Greenfoot.getRandomNumber(1500);
        b=Greenfoot.getRandomNumber(1500);
        x=150;
        y=150;
        Ambiente();
        Mira m=new Mira();
        addObject(m,400,300);
        f=new Base();
        addObject(f,x,y);
        BaseEnemiga be=new BaseEnemiga();
        addObject(be,1400,1300);
        MiniMapa mm=new MiniMapa();
        addObject(mm,720,50);
        Recurso re=new Recurso();
        addObject(re,100,50);
        CantidadUnidades cu=new CantidadUnidades();
        addObject(cu,250,50);
       
    }

    public void Ambiente()
    {
        while(Greenfoot.getRandomNumber(20)!=1)
        {
            a=Greenfoot.getRandomNumber(1500);
            b=Greenfoot.getRandomNumber(1500);
            Cosa am=new Cosa();
            addObject(am,a,b);
        }
    }

    public Base getBase()
    {
        return f;
    }


}