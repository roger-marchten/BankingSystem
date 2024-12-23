public class PremiumAccount implements iAccounts {
    private int accountNumber;
    private double balance;

    /**
     * Constructor for PremiumAccount.
     * @param accountNumber The account number (int).
     */
    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) {
            return 0; // Invalid withdrawal amount
        }

        balance -= amount; // Deduct the full amount, even if it causes a negative balance
        return amount;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
