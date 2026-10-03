package implementor;

public class EmailChannel implements Channel{
    public String send(String message){
        return "EMAIL-> " + message;
    }
}
