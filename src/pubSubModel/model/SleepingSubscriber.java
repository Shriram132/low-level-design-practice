package pubSubModel.model;

public class SleepingSubscriber implements Isubscriber {

    @Override
    public void consume(String message){
        System.out.println(message);
    }
}
