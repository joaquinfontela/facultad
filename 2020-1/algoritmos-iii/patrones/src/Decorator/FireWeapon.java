package Decorator;

public class FireWeapon extends CharacterDecorator {

    public FireWeapon(Character character) {

        super(character);
    }

    @Override
    public void attack(Character enemy) {

        super.attack(enemy);
        enemy.recieveAttack(15);
    }
}
