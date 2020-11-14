package services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("genaDiscountService") //TODO primary
public class GenaDiscountService implements DiscountService {
    @Override
    public double calculate(int numberOfItemsBought) {
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
