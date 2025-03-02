package pubSubModel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Topic {

    private String id;
    private String topicName;

    private List<TopicSubscriber> subscribers;

    private List<String> messages;

    public Topic (String topicName){
        this.id = UUID.randomUUID().toString();
        this.topicName = topicName;
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public List<TopicSubscriber> getSubscribers() {
        return subscribers;
    }

    public List<String> getMessages() {
        return messages;
    }
}
