package Singleton;

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        //...
    }

    public static Singleton getInstance() {

        return INSTANCE;
    }

    public void metodoDeSingleton() {

        System.out.println("EL SINGLETON FUNCIONA");
    }
}
