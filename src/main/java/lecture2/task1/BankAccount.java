package lecture2.task1;

public class BankAccount implements Printable {
    private String accountName;
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public void print() {
        System.out.println("Баланс аккаунта " + this.balance);
    }
}
