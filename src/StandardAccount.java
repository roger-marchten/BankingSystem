public class StandardAccount implements iAccounts {
    private int accountNumber;
    private double balance;
    private double creditLimit;


    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0.0;
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

        double maxWithdrawal = balance - creditLimit;
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

