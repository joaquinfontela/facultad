package Decorator;

public class Human extends Character {

    public Human() {

         life = 100;
         attack = 20;
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
