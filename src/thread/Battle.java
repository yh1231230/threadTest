package thread;

/**
 * Runnable接口实现多线程
 */
public class Battle implements Runnable{
    private Hero h1;
    private Hero h2;
    public Battle(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }
    @Override
    public void run() {
        while (!(h2.isDead()||h1.isDead()))
            h1.attack(h2);
    }
}
