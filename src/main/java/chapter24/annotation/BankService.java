package chapter24.annotation;

/**
 * @author karl xie
 */
public class BankService {

    @Secure
    public void transferMoney(double amount) {
        System.out.println("Transferring money: " + amount);
    }
    @Secure
    public void checkBalance() {
        System.out.println("Checking balance");
    }
}