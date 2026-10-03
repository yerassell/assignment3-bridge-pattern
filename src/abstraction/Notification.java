package abstraction;
import implementor.Channel;

public abstract class Notification {
    private final String id;
    protected Channel channel;

    protected Notification(String id, Channel channel){
        this.id=id;
        this.channel=channel;
    }

    public String getId() {return id;}

    public abstract String execute();
    
    public void setImplementation(Channel channel){
        this.channel=channel;
    }
}
