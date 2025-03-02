package validationSystem.service;

import validationSystem.model.Attribute;

public class NumberFormatValidationHandler extends BaseValidationHandler {

    private final String attributeName;

    public NumberFormatValidationHandler(String attributeName){
        this.attributeName = attributeName;
    }

    @Override
    public boolean isValid(Attribute attribute){
        if(attributeName.equals(attribute.getName())){
            try{
                Integer.parseInt(attribute.getValue());
            } catch (NumberFormatException e){
                System.out.println("invalid attribute"+ attribute.getName());
                return false;
            }
        }
        return validateNext(attribute);
    }

}
