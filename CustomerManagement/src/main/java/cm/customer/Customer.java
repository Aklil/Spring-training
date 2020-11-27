package cm.customer;

public class Customer {
    private int id;
    private String name;
    private String tinNum;
    private String bankAccount;

    public Customer(int id, String name, String tinNum, String bankAccount) {
        this.id = id;
        this.name = name;
        this.tinNum = tinNum;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTinNum() {
        return tinNum;
    }

    public void setTinNum(String tinNum) {
        this.tinNum = tinNum;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
