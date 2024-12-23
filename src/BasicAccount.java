public class BasicAccount implements iAccounts{

    private int accountNumber;
    private double balance;
    private double withdrawalLimit;


    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        // Ensure the withdrawal limit is positive; otherwise, default to 0
        this.withdrawalLimit = withdrawalLimit > 0 ? withdrawalLimit : 0.0;
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

        double maxWithdrawal = Math.min(balance, withdrawalLimit);
        double actualWithdrawal = Math.min(amount, maxWithdrawal);
        balance -= actualWithdrawal;
        return actualWithdrawal;
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
