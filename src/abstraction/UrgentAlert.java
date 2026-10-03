package abstraction;
import implementor.Channel;

public class UrgentAlert extends Notification{
    private final String message;

    public UrgentAlert(String id, Channel channel, String message){
        super(id, channel);
        this.message=message;
    }

    public String getMessage() {return message;}

    public String execute(){
        return channel.send("URGENT: " + message);
    }
}
