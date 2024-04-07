package Lesson6;

public class CreditCard {

    String accountNumber;
    int currentAmount, sum;

    public CreditCard(String accountNumber, int currentAmount) {
        this.accountNumber = accountNumber;
        this.currentAmount = currentAmount;
    }
    void AddAmount(int sum){
        this.currentAmount = this.currentAmount + sum;
    }

    void WhithdrawAmount(int sum){
        this.currentAmount = this.currentAmount - sum;
    }
    void ShowInfomation(){
        System.out.println("Текущий номер счета: " + this.accountNumber + ", текущая сумма: " + this.currentAmount);

    }
}
