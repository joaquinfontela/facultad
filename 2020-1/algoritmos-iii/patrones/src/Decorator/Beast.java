package Decorator;

public class Beast extends Character {

    public Beast() {

        life = 80;
        attack = 35;
    }

    @Override
    public void attack(Character enemy) {

        enemy.recieveAttack(attack);
    }

    @Override
    public void recieveAttack(int damage) {

        life -= damage;
    }

    @Override
    public int getLife() {

        return life;
    }
}
