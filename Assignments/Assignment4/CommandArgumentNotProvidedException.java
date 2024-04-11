package edu.ucalgary.oop;

public class CommandArgumentNotProvidedException extends Throwable {
    public CommandArgumentNotProvidedException(){
        super("No arguments were founds");
    }
    
}
