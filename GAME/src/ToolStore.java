public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "STORE");
    }

    public boolean getLocation() {
        System.out.println("Money : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Your choice : ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                break;
        }

        return true;
    }

    public int armorMenu() {
        System.out.println("1. Light \t <Price : 15 - Block : 1>");
        System.out.println("2. Medium \t <Price : 25 - Block : 3>");
        System.out.println("3. Heavy \t <Price : 40 - Block : 5>");
        System.out.println("4. Exit");
        System.out.print("Select armor : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int block = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                block = 1;
                aName = "Light Armor";
                price = 15;
                break;
            case 2:
                block = 3;
                aName = "Medium Armor";
                price = 25;
                break;
            case 3:
                block = 5;
                aName = "Heavy Armor";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid action!");
                return;
        }

        if (player.getMoney() >= price) {
            player.getInventory().setArmor(block);
            player.getInventory().setaName(aName);
            player.setMoney(player.getMoney() - price);
            System.out.println(aName + " purchased, Blocked Damage : " + player.getInventory().getArmor());
            System.out.println("Remaining Money : " + player.getMoney());
        } else {
            System.out.println("Insufficient money!");
        }
    }

    public int weaponMenu() {
        System.out.println("1. Pistol\t<Price : 25 - Damage : 2>");
        System.out.println("2. Sword\t<Price : 35 - Damage : 3>");
        System.out.println("3. Rifle\t<Price : 45 - Damage : 7>");
        System.out.println("4. Exit");
        System.out.print("Select weapon : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid action!");
                return;
        }

        if (player.getMoney() >= price) {
            player.getInventory().setDamage(damage);
            player.getInventory().setwName(wName);
            player.setMoney(player.getMoney() - price);
            System.out.println(wName + " purchased, Previous Damage : " + player.getDamage() + ", New Damage : " 
                    + player.getTotalDamage());
            System.out.println("Remaining Money : " + player.getMoney());
        } else {
            System.out.println("Insufficient money!");
        }
    }
}
