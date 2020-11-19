package services;

import org.springframework.stereotype.Service;

@Service
public class EidDiscounService implements DiscountService {
    @Override
    public double calculate(int numberOfItemsBought) {
        return 0;
    }
}
