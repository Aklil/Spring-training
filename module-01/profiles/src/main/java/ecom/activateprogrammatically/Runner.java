package ecom.activateprogrammatically;

import ecom.activatebyproperty.ApplicationConfig;
import ecom.services.DiscountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext();

        //programmatically Activate profile
        context.getEnvironment().setActiveProfiles("eid");

        context.register(ApplicationConfig.class);
        context.refresh();

        var discountService = context.getBean(DiscountService.class);

        System.out.println("Discount: " + discountService.calculate(45));

    }
}
