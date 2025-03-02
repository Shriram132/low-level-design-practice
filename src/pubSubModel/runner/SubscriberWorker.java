package pubSubModel.runner;

import pubSubModel.model.Topic;
import pubSubModel.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class SubscriberWorker implements  Runnable{

    private  Topic topic;
    private TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber){
            do{
                int currOffset= topicSubscriber.getOffset();
                while(currOffset>=topic.getMessages().size()){
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                String message = topic.getMessages().get(currOffset);
                topicSubscriber.getSubscriber().consume(message);
                topicSubscriber.setOffset(topicSubscriber.getOffset()+1);
            } while(true);
        }
    }
}
