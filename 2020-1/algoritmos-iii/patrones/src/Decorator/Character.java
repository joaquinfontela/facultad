package Decorator;

public abstract class Character {

    public int life;
    protected int attack;

    public abstract void attack(Character enemy);

    public abstract void recieveAttack(int damage);

    public abstract int getLife();
}
