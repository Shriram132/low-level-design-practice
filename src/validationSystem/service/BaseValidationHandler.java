package validationSystem.service;

import validationSystem.model.Attribute;

public abstract class BaseValidationHandler implements ValidationHandler {
    protected ValidationHandler next;


    public void setNext(ValidationHandler validationHandler){
        this.next = validationHandler;
    }

    protected boolean validateNext(Attribute attribute){
        if(next == null){
            return true;
        }
        return next.isValid(attribute);
    }

}
