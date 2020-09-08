package Decorator;

public class Sword extends CharacterDecorator {

    public Sword(Character character) {
        super(character);
    }

    @Override
    public void attack(Character enemy) {

        super.attack(enemy);
        enemy.recieveAttack(10);
    }
}
