package thread;

/**
 * synchronized独占对象避免脏数据
 */
public class SynchronizedTest {
    public static void main(String[] args) {
    Hero shiTou=new Hero("石头人",10000,200);
        System.out.println("初始血量为"+shiTou.getHp());

        int n=10000;
        Thread[] addThread=new Thread[n];
        Thread[] reduceThread=new Thread[n];

        for(int i=0;i<n;i++){
            Thread t=new Thread(){
                @Override
                public void run() {
                    synchronized (shiTou){
                    shiTou.recover();
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i]=t;
        }

        for(int i=0;i<n;i++){
            Thread t=new Thread(){
                @Override
                public void run() {
                    shiTou.hurt();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i]=t;
        }

        for (Thread t:addThread
             ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Thread t:reduceThread){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(n+"个增加线程和"+n+"个减少线程结束后血量变成"+shiTou.getHp());
    }
}
