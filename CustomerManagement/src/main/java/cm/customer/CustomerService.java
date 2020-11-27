package cm.customer;

public interface CustomerService {
    public Customer getCustomer(int customerId);
    public Customer getCustomerByTin(String tin);
}
