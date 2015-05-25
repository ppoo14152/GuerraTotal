import greenfoot.*;
/**
 * Se ingresa la base 1
 */

public class Mapa1 extends Mapa
{
   
    public Mapa1()
    {
        showText("1",500,50);
        BaseEnemiga1 be=new BaseEnemiga1();
        addObject(be,1300,1300);
    }
}
