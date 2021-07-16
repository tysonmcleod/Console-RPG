package Functionality.Exceptions;
// Invalid armor exception for wrong char type or level
public class InvalidArmorException extends Exception{
    public InvalidArmorException(String s){
        super(s);
    }
}
