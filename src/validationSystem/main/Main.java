package validationSystem.main;

import validationSystem.factory.ValidationFactory;
import validationSystem.model.Attribute;
import validationSystem.service.NumberFormatValidationHandler;
import validationSystem.service.RangeValidationHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Attribute attribute1 = new Attribute("foo","5");
        ValidationFactory validationFactory = new ValidationFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of validation rules:");
        int numRules = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numRules; i++) {
            System.out.println("Enter rule type (range/numberFormat):");
            String ruleType = scanner.nextLine();

            System.out.println("Enter attribute name:");
            String attributeName = scanner.nextLine();

            switch (ruleType) {
                case "range":
                    System.out.println("Enter min value:");
                    int min = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter max value:");
                    int max = Integer.parseInt(scanner.nextLine());
                    validationFactory.addHandler(new RangeValidationHandler(attributeName, min, max));
                    break;
                case "numberFormat":
                    validationFactory.addHandler(new NumberFormatValidationHandler(attributeName));
                    break;
                default:
                    System.out.println("Invalid rule type.");
            }
        }

        System.out.println(validationFactory.getValidationList().get(0).isValid(attribute1));


//        NumberFormatValidationHandler numberFormatValidationHandler = new NumberFormatValidationHandler(attribute1.getName());
//        validationFactory.addHandler(numberFormatValidationHandler);
//        RangeValidationHandler rangeValidationHandler = new RangeValidationHandler(attribute1.getName(),4,9);
//        validationFactory.addHandler(rangeValidationHandler);

        //System.out.println(numberFormatValidationHandler.isValid(attribute1));

    }

}
