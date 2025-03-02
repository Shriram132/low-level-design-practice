package pubSubModel.model;

import java.util.UUID;

public interface Isubscriber {

    void consume(String message);
}
