package thread;

/**
 * wait()和notify()交互
 */
public class Test extends Hero {
    public synchronized void recover() {
        hp += 1;
        System.out.println("回一滴血，回复后血量为" + hp);
        this.notify();
    }

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp -= 1;
        System.out.println("扣一滴血，扣除后血量为" + hp);
    }




    public static void main(String[] args) {
        Hero xiazi = new Test();
        xiazi.setName("李青");
        xiazi.setHp(100);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    xiazi.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    xiazi.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
