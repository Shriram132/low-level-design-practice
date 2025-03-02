package pubSubModel.service;

import pubSubModel.model.Isubscriber;
import pubSubModel.model.Topic;
import pubSubModel.model.TopicSubscriber;
import pubSubModel.runner.TopicHandler;

import java.util.HashMap;
import java.util.Map;

public class Queue {

    Map<Topic,TopicHandler> topicHandlerMap = new HashMap<>();

    public Topic createTopic(String topicName){
        Topic topic = new Topic(topicName);
        topicHandlerMap.put(topic,new TopicHandler(topic));
        return topic;
    }

    public void subscribe(Topic topic, Isubscriber isubscriber){
        topic.getSubscribers().add(new TopicSubscriber(isubscriber));
    }

    public void publish(Topic topic , String message){
        topic.getMessages().add(message);
        new Thread(() -> topicHandlerMap.get(topic).publish()).start();
    }

}
