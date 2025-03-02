package validationSystem.factory;

import validationSystem.service.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationFactory {

    private List<ValidationHandler> validationHandlerList = new ArrayList<>();

    public List<ValidationHandler> getValidationList(){
        return validationHandlerList;
    }

    public void addHandler(ValidationHandler handler){
        if(!validationHandlerList.isEmpty()){
            validationHandlerList.get(validationHandlerList.size() - 1).setNext(handler);
            validationHandlerList.add(handler);
        } else{
            validationHandlerList.add(handler);
        }

    }
}
