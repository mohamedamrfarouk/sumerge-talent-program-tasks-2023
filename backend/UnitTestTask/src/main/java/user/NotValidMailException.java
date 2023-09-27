package user;

public class NotValidMailException extends Exception{
    public NotValidMailException(String statement){
        super(statement);
    }
}