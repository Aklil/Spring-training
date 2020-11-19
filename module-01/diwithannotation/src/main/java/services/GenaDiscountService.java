package services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("genaService") //TODO primary
//@Component   // spring names this bean as "genaDiscountService" by default . i.e takes the class names and downcasing the first letter
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
