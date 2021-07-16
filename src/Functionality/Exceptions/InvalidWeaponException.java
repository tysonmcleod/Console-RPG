package Functionality.Exceptions;
// Invalid weapon exception for wrong char type or level
public class InvalidWeaponException extends Exception{
    public InvalidWeaponException(String s){
        super(s);
    }
}
