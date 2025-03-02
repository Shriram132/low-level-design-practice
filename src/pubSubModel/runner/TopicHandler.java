package pubSubModel.runner;

import pubSubModel.model.Topic;
import pubSubModel.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish(){
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()){
            startSubscriberWorkers(topic,topicSubscriber);
        }
    }

    private void startSubscriberWorkers(Topic topic, TopicSubscriber topicSubscriber) {
        if(!subscriberWorkers.containsKey(topicSubscriber.getId())){
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic,topicSubscriber);
            subscriberWorkers.put(topicSubscriber.getId(),subscriberWorker);
            new Thread(subscriberWorker).start();
        }

        SubscriberWorker subscriberWorker = subscriberWorkers.get(topicSubscriber.getId());
        new Thread(subscriberWorker).notifyAll();
    }
}
