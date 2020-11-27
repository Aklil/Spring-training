package cm.approvalprocess;

import cm.customer.Customer;
import cm.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalProcessServiceImpl implements ApprovalProcessService {

    private final CustomerService customerService;

    @Autowired
    ApprovalProcessServiceImpl(CustomerService customerService){
        this.customerService = customerService;
    }
    public boolean approve(int customerId) {
        System.out.println("About to approve customer ---");
        Customer customer = customerService.getCustomer(customerId);
        return customer.getTinNum() != null;
    }
}
