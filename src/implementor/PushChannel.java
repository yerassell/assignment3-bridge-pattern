package implementor;

public class PushChannel implements Channel{
    public String send(String message){
        return "PUSH-> " + message;
    }
}
