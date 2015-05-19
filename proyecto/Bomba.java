import greenfoot.*;
/**
 * Hace que la bomba se mueva por todo el mapa y que detecte si es que toca la base enemiga para 
 * destruirla y pasar a otro nivel
 */
public class Bomba extends Mira
{
    private int permitir;
    private int permitir2;
    private GreenfootImage[] lord=new GreenfootImage[4];
    private World w;
   
    public Bomba()
    {
        permitir=0;
        permitir2=0;
        w=getWorld();
        
    }

    public void act() 
    {
        int x=0;
        int y=0;
        MouseInfo mouse=Greenfoot.getMouseInfo();  
        perdiste();
        if(Greenfoot.mouseClicked(this))
        {
            permitir=1;
            removeTouching(Selecciones.class);
            removeTouching(Buldier.class);
        }
        if(permitir==1&&Greenfoot.mouseClicked(null))
        {
            x=mouse.getX();
            y=mouse.getY();
            permitir2=1;
            turnTowards(mouse.getX(),mouse.getY());

        }
        visualizarEnMapa();
        if(permitir2==1)
        {
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { 
                permitir2=0;
            }
            else
            {
                move(5); 
            }  
        }  
        if(Greenfoot.isKeyDown("q"))
            permitir=0;
    }    

    public void visualizarEnMapa()
    {
        getWorld().addObject(new Bueno(),660+(getX()/10),10+(getY()/10));

    }

    public void perdiste()
    {
        if(isTouching(BaseEnemiga.class))
        {
            
            removeTouching(BaseEnemiga.class);
            permitir=1;
            w=new Ganaste();
            Greenfoot.setWorld(w);

        }
        else
        if(isTouching(BaseEnemiga2.class))
        {
            
            removeTouching(BaseEnemiga2.class);
            permitir=1;
            w=new Ganaste2();
            Greenfoot.setWorld(w);

        }
        else
        if(isTouching(BaseEnemiga3.class))
        {
            Reco rec=new Reco();
            rec.guardaRecords(1600);
            removeTouching(BaseEnemiga3.class);
            permitir=1;
            w=new Ganaste3();
            Greenfoot.setWorld(w);

        }
    }


}

