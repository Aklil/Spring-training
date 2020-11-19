package ecom.activatebyproperty;

import ecom.services.DiscountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        context.registerShutdownHook();

        System.out.println("Active Profile: " + context.getEnvironment().getActiveProfiles()[0]);

        var discountService = context.getBean(DiscountService.class);

        System.out.println("Discount: " + discountService.calculate(45));

    }
}
