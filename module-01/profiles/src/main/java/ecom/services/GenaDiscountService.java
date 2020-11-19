package ecom.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("gena")
public class GenaDiscountService implements DiscountService {

    /*@Value("${JAVA_HOME}")  // for property source demo purpose
    private String javaHomeTest;*/

    @Override
    public double calculate(int numberOfItemsBought) {
        //System.out.println("Java home: " + javaHomeTest);

        double discount = 0.0;
       if(numberOfItemsBought >= 100)
           discount = 0.30;
       else if(numberOfItemsBought >= 50)
           discount = 0.20;
       else if(numberOfItemsBought >=20)
           discount = 0.10;
       else
           discount = 0.05;

       return discount;
    }
}
