package validationSystem.service;

import validationSystem.model.Attribute;

public class RangeValidationHandler extends BaseValidationHandler{

    private final String attributeName;
    private final int min;
    private final int max;

    public RangeValidationHandler(String attributeName ,int min, int max){
        this.attributeName = attributeName;
        this.max = max;
        this.min = min;
    }
    @Override
    public boolean isValid(Attribute attribute){
        if(attributeName.equals(attribute.getName())){
            int val;
            try{
                val = Integer.parseInt(attribute.getValue());
            } catch (NumberFormatException e){
                System.out.println("invalid Value of Attribute");
                return false;
            }
            if(val<min || val> max){
                return false;
            }
        }
        return validateNext(attribute);
    }
}
