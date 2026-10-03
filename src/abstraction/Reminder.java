package abstraction;
import implementor.Channel;

public class Reminder extends Notification{
    private final String message;

    public Reminder(String id, Channel channel, String message){
        super(id, channel);
        this.message=message;
    }

    public String getMessage() {return message;}

    public String execute(){
        return channel.send("Reminder: " + message);
    }
}
