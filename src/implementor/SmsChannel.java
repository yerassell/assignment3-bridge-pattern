package implementor;

public class SmsChannel implements Channel{
    public String send(String message){
        return "SMS-> " + message;
    }
}
