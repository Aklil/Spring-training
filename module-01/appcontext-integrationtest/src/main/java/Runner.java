import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.DiscountService;

public class Runner {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        //var discountService = context.getBean(DiscountService.class);
        var discountService = context.getBean("genaDiscountService", DiscountService.class);

        System.out.println("Discount: " + discountService.calculate(45));

    }
}
