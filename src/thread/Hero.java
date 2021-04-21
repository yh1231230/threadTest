package thread;

public class Hero {
    public String name;
    public float hp;
    public float damage;

    public void attack(Hero hero) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hero.hp -= damage;
        if (hero.hp < 0)
            hero.hp = 0;
        System.out.println(name + "正在攻击" + hero.name + "," + hero.name + "血量剩余" + hero.hp);
        if (hero.isDead()) {
            System.out.println(hero.name + "阵亡");
        }
    }

    public void recover(){
        hp+=1;
    }

    public void hurt(){
        synchronized(this) {
            hp -= 1;
        }
    }

    public void aDuGen() {
        for (int x = 0; x < 2; x++) {
                for (int i = 1; i < 4; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("波动拳第" + i + "发");
                }

            System.out.println("开始五秒充能");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean isDead() {
        return (hp == 0);
    }

    public Hero() {

    }

    public Hero(String name, float hp, float damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
