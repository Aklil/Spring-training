package cm.customer;

import cm.common.TinValidator;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    public Customer getCustomer(int customerId) {
        return new Customer(1, "Abebe Bekele", "77883838383", "100003388383");
    }

    @TinValidator
    public Customer getCustomerByTin(String tin) {
        return new Customer(1, "Abebe Bekele", "77883838383", "100003388383");
    }
}
