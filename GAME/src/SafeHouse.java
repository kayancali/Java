public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
        //TODO Auto-generated constructor stub
    }

    public boolean getLocation()
    {   
        player.setHealthy(player.getrHealthy());
        
        System.out.println("Şuan güvenli evdesiniz");
        System.out.println("İyileşme tamamlandi");
        
        return true;
    }

}
