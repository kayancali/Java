import java.util.Scanner;

public class Player {
    private int damage, healthy, money, rHealthy;
    private String name, cName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlayer("Samurai", 5, 21, 15);
                break;
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knight", 8, 24, 5);
                break;
            default:
                initPlayer("Samurai", 5, 21, 15);
                break;
        }
        System.out.println("Karakter Olusturuldu! Adi=" + getcName() + " ,Hasar=" + getDamage() + " ,Saglik="
                + getHealthy() + " ,Para=" + getMoney());
    }

    public int chaMenu() {
        System.out.println("Lutfen bir karakter seciniz: ");
        System.out.println("1- Samurai \t Hasar: 5 \t Saglik: 21 \t Para: 15");
        System.out.println("2- Archer \t Hasar: 7 \t Saglik: 18 \t Para: 20");
        System.out.println("3- Knight \t Hasar: 8 \t Saglik: 24 \t Para: 5");
        System.out.print("Karakter Seciminiz: ");
        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.print("Lutfen gecerli bir karakter seciniz: ");
            chaID = scan.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getDamage();
    }

    public void initPlayer(String cName, int dmg, int hlthy, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setrHealthy(hlthy);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inv) {
        this.inventory = inv;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
}