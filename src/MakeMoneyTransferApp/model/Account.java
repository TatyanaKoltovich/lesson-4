package MakeMoneyTransferApp.model;

public class Account {

    private String accountNumber;
    private Integer amount;

    public Account(String accountNumber, Integer amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.getAccountNumber() + "=" + this.getAmount().toString();
    }


}
