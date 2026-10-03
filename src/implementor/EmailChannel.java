package implementor;

public class EmailChannel implements Channel{
    public String send(String message){
        return "Email: " + message;
    }
}
