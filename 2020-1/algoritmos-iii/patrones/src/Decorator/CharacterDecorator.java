package Decorator;

public abstract class CharacterDecorator extends Character {

    protected Character character;

    public CharacterDecorator(Character character) {

        this.character = character;
    }

    @Override
    public void attack(Character enemy) {

        character.attack(enemy);
    }

    @Override
    public void recieveAttack(int damage) {

        character.recieveAttack(damage);
    }

    public int getLife() {

        return character.getLife();
    }
}
