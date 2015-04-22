import greenfoot.*;
public class Guerreros extends Actor
{
    private int band;
    private int x;
    private int y;
    private int band2;
    private int i;
    private int h;
    private GreenfootImage[] dragon=new GreenfootImage[4];
    public Guerreros()
    {
        band=0;
        band2=0;
        h=0;
        for(i=0;i<4;i++)
            dragon[i]=new GreenfootImage("dragon_"+i+".png");
     
        
    }
    public void act() 
    {
       MouseInfo mouse=Greenfoot.getMouseInfo();  
       if(Greenfoot.mouseClicked(this))
       {
           band=1;
       }
       if(band==1&&Greenfoot.mouseClicked(null))
       {
           x=mouse.getX();
           y=mouse.getY();
           band2=1;
           turnTowards(mouse.getX(),mouse.getY());
       }
       if(band2==1)
       {
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { setImage(dragon[3]);
                band2=0;
            }
            else
            {
               setImage(dragon[h]);//permite el cambio de imagenes
               h+=1;
               if(h==4)
               h=0;
               move(20); 
            }  
       }  
       if(Greenfoot.isKeyDown("q"))
          band=0;
       /*if(getObjectsInRange(10,null))//metodo para atacar
       {
           //getX()=Enemigo().getX();
       }*/
    }    
    
}
