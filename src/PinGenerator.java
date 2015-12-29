
public abstract class PinGenerator {

    public static String pinGenerator(){

        //4 different ints for making cases like 0XXX, 00XX etc.

        int a, b, c, d;

        a = (int)(Math.random()*10);
        b = (int)(Math.random()*10);
        c = (int)(Math.random()*10);
        d = (int)(Math.random()*10);

        return ""+a+b+c+d;
    }

}
