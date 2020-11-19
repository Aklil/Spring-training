package ecom.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("eid")
public class EidDiscountService implements DiscountService {
    //@Override
    public double calculate(int numberOfItemsBought) {
        return 0;
    }
}
