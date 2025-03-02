package validationSystem.service;

import validationSystem.model.Attribute;

public interface ValidationHandler {

    boolean isValid(Attribute attribute);
    void setNext(ValidationHandler validationHandler);
}
