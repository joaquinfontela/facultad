package Decorator;

public class Shield extends CharacterDecorator {

    public Shield(Character character) {
        super(character);
    }

    @Override
    public void recieveAttack(int damage) {

        super.recieveAttack(damage/2);
    }
}
