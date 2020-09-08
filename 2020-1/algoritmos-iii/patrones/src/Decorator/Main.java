package Decorator;

public class Main {

    public static void main(String[] args) {

        Character player = new FireWeapon(new Sword(new Human()));
        Character beast = new Shield(new Sword(new Beast()));

        System.out.println(player.getLife()); //100
        System.out.println(beast.getLife()); //80

        player.attack(beast);
        beast.attack(player);

        System.out.println(player.getLife()); //55
        System.out.println(beast.getLife()); //58

    }
}
