package thread;

public class A01 {
    public static void main(String[] args) {

        Hero gareen = new Hero();
        gareen.setName("盖伦");
        gareen.setHp(10000);
        gareen.setDamage(100);

        Hero teemo = new Hero();
        teemo.setName("提莫");
        teemo.setHp(1000);
        teemo.setDamage(70);

        Hero mf = new Hero();
        mf.setName("女枪");
        mf.setHp(1100);
        mf.setDamage(140);

        Hero leesin = new Hero();
        leesin.setName("盲僧");
        leesin.setHp(1500);
        leesin.setDamage(120);
/*
        while(!teemo.isDead()){
            gareen.attack(teemo);
        }

        while(!leesin.isDead()){
            mf.attack(leesin);
        }

 */
   /*
         KillThread k1=new KillThread(gareen,teemo);
         k1.start();
         KillThread k2=new KillThread(mf,leesin);
         k2.start();
    */
    /*
        Battle b1 = new Battle(gareen, teemo);
        new Thread(b1).start();
        Battle b2 = new Battle(mf, leesin);
        new Thread(b2).start();
     */

        gareen.aDuGen();


        Thread t1=new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    gareen.attack(teemo);
                }
            }
        };
        t1.start();


        Thread t2=new Thread(){
            @Override
            public void run() {
                while (!leesin.isDead())
                    mf.attack(leesin);
            }
        };
        t2.start();

    }
}
