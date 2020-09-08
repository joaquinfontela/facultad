package Facade;

public class CardReader {

    public boolean cardIsValid(Integer accountId){

        return ((accountId >= 1000000) && (accountId <= 9999999));
    }
}
