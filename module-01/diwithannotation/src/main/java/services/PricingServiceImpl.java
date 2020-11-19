package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ActionMapUIResource;

@Service
public class PricingServiceImpl implements PricingService {

    @Autowired  // field injection is not recommended
    @Qualifier("genaDiscountService")
    private DiscountService discountService;

    //private final DiscountService discountService;
/*
    @Autowired
    public PricingServiceImpl(DiscountService discountService) {
        this.discountService = discountService;
    }
*/


    @Override
    public double calculatePrice(int numOfProducts, double unitPrice) {

        double discount = discountService.calculate(numOfProducts);

        double grossTotal = numOfProducts * unitPrice;

        return grossTotal - grossTotal * discount;
    }
}
