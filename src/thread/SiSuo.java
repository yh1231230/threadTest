package thread;

/**
 * 测试死锁
 */
public class SiSuo {
    public static void main(String[] args) {
        Hero ahri = new Hero();
        ahri.setName("阿狸");
        Hero annie = new Hero();
        annie.setName("安妮");
        Hero naMei = new Hero();
        naMei.setName("娜美");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (ahri) {
                    System.out.println("t1占有阿狸");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占有安妮");
                    System.out.println("等待安妮");
                    synchronized (annie) {
                        System.out.println("安妮玩熊");
                    }
                }
            }
        };

        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (annie) {
                    System.out.println("t2占有安妮");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2试图占有娜美");
                System.out.println("等待娜美");
                synchronized (naMei) {
                    System.out.println("娜美玩水");
                }
            }
            }
        };

        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                synchronized (naMei) {
                    System.out.println("t3占有娜美");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3试图占有阿狸");
                    System.out.println("等待阿狸");
                    synchronized (ahri) {
                        System.out.println("阿狸玩球");
                    }
                }
            }
        };

        t3.start();

    }
}
