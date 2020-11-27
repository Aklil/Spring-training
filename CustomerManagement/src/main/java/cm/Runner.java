package cm;

import cm.approvalprocess.ApprovalProcessService;
import cm.customer.Customer;
import cm.customer.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ApprovalProcessService approvalService = context.getBean(ApprovalProcessService.class);

        boolean isApproved = approvalService.approve(1);

        System.out.println("Is Customer Approved: " + isApproved);

        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.getCustomerByTin("ttoioot");

    }
}
