public abstract class BattleLoc extends Location {
    protected Monster monster;
    protected String award;

    BattleLoc(Player player, String name, Monster monster, String award) {
        super(player, name);
        this.monster = monster;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = monster.monstCount();
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + monster.getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç: ");
        
        String selCase = scan.nextLine().toUpperCase();
        
        while (!selCase.equals("S") && !selCase.equals("K")) {
            System.out.print("Geçersiz giriş! Lütfen <S>avaş veya <K>aç seçeneklerinden birini seçin: ");
            selCase = scan.nextLine().toUpperCase();
        }
        
        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz!");
    
                if (this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println(this.award + " kazandınız!");
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println(this.award + " kazandınız!");
                    player.getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println(this.award + " kazandınız!");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
    
            if (player.getHealthy() <= 0) {
                System.out.println("Öldünüz!");
                return false;
            }
        }
        
        return true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = monster.getHealth();
            playerStats();
            enemyStats();

            while (player.getHealthy() > 0 && monster.getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç: ");
                String selCase = scan.nextLine().toUpperCase();

                if (selCase.equals("V")) {
                    System.out.println("Siz vurdunuz!");
                    monster.setHealth(monster.getHealth() - player.getTotalDamage());
                    afterHit();

                    if (monster.getHealth() > 0) {
                        System.out.println("\nCanavar size vurdu!");
                        player.setHealthy(player.getHealthy() - Math.max(0, monster.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (monster.getHealth() <= 0 && player.getHealthy() > 0) {
                System.out.println("Düşmanı yendiniz!");
                player.setMoney(player.getMoney() + monster.getAward());
                System.out.println("Güncel Paraniz: " + player.getMoney());
                monster.setHealth(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri\n--------------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Silah: " + player.getInventory().getwName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Zırh: " + player.getInventory().getaName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + monster.getName() + " Değerleri\n--------------");
        System.out.println("Can: " + monster.getHealth());
        System.out.println("Hasar: " + monster.getDamage());
        System.out.println("Ödül: " + monster.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncu Canı: " + player.getHealthy());
        System.out.println(monster.getName() + " Canı: " + monster.getHealth());
        System.out.println();
    }
}
