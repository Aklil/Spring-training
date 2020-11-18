import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.DiscountService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ContextConfiguration
 *  Defines class-level metadata that is used to determine how to load and configure
 *  an ApplicationContext for integration tests.
 */

// @RunWith(SpringRunner.class) for JUnit 4
@ExtendWith(SpringExtension.class)  // for JUnit 5
@ContextConfiguration(classes = AppConfig.class)
public class DiscountServiceTest {

    @Autowired
    //@Qualifier("discountService")
    private DiscountService discountService;

    @Test
    public void shouldCalculateDiscount(){
        var numberOfItems = 25;
        var expectedDiscount = 0.10;

        var discount = discountService.calculate(numberOfItems);

        assertEquals(discount, expectedDiscount);

    }


}
