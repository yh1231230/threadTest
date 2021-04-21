package thread;

/**
 * 继承Thread类实现多线程
 */
public class KillThread extends Thread{
    private Hero h1;
    private Hero h2;
    public KillThread(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }

    @Override
    public void run() {
        while(!h2.isDead()){
            h1.attack(h2);
        }
    }
}
