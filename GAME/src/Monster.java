import java.util.Random;

public class Monster {
    private int damage,health,award,maxNum;
    private String name;

    
    public Monster(int damage, int health, int award, int maxNum, String name) {
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.maxNum = maxNum;
        this.name = name;
    }

    public int monstCount( )
    {
        Random rand = new Random();
        return rand.nextInt(this.maxNum) + 1;

    }




    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAward() {
        return award;
    }
    public void setAward(int award) {
        this.award = award;
    }
    public int getMaxNum() {
        return maxNum;
    }
    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    

}
