package services;

import org.springframework.stereotype.Service;

// this is to demonstrate unique bean naming //default ?? primary ?? its own name??
//@Service
public class FasikaDiscountService implements DiscountService {
    @Override
    public double calculate(int numberOfItemsBought) {
        double discount = 0.0;
        if(numberOfItemsBought >= 100)
            discount = 0.20;
        else if(numberOfItemsBought >= 50)
            discount = 0.10;
        else if(numberOfItemsBought >=20)
            discount = 0.05;
        else
            discount = 0.02;

        return discount;
    }
}
