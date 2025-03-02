package pubSubModel.model;

import java.util.ArrayList;
import java.util.UUID;

public class TopicSubscriber {

    private String id;
    private int offset;
    private Isubscriber subscriber;

    public  TopicSubscriber (Isubscriber subscriber){
        this.id = UUID.randomUUID().toString();
        this.subscriber = subscriber;
        this.offset = 0;
    }

    public String getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }

    public Isubscriber getSubscriber() {
        return subscriber;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
