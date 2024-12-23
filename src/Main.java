public class Main {
    public static void main(String[] args) {
        // Create the bank
        Bank bank = new Bank();

        // Open accounts
        StandardAccount standardAccount = new StandardAccount(1, -100);
        BasicAccount basicAccount = new BasicAccount(2, 50);
        PremiumAccount premiumAccount = new PremiumAccount(3);

        bank.OpenAccount(standardAccount);
        bank.OpenAccount(basicAccount);
        bank.OpenAccount(premiumAccount);

        // Test deposits
        standardAccount.deposit(200);
        basicAccount.deposit(100);
        premiumAccount.deposit(500);

        System.out.println("Standard Account Balance: " + standardAccount.getCurrentBalance()); // Should be 200
        System.out.println("Basic Account Balance: " + basicAccount.getCurrentBalance()); // Should be 100
        System.out.println("Premium Account Balance: " + premiumAccount.getCurrentBalance()); // Should be 500

        // Test withdrawals
        double standardWithdraw = standardAccount.withdraw(350); // Should withdraw 300 (200 balance + 100 credit limit)
        double basicWithdraw = basicAccount.withdraw(70); // Should withdraw 50 (withdrawal limit)
        double premiumWithdraw = premiumAccount.withdraw(600); // Should withdraw 600 (no limit)

        System.out.println("Standard Account Withdrawn: " + standardWithdraw);
        System.out.println("Basic Account Withdrawn: " + basicWithdraw);
        System.out.println("Premium Account Withdrawn: " + premiumWithdraw);

        System.out.println("Standard Account Balance After Withdrawal: " + standardAccount.getCurrentBalance());
        System.out.println("Basic Account Balance After Withdrawal: " + basicAccount.getCurrentBalance());
        System.out.println("Premium Account Balance After Withdrawal: " + premiumAccount.getCurrentBalance());

        // Test Bank methods
        System.out.println("\n--- Bank Operations ---");

        // Get all accounts
        System.out.println("Total Accounts in Bank: " + bank.GetAllAccounts().size()); // Should be 3

        // Get accounts in debt
        System.out.println("Accounts in Debt: " + bank.GetAllAccountsInDebt().size()); // StandardAccount should be in debt

        // Get accounts with balance > 50
        System.out.println("Accounts with Balance > 50: " + bank.GetAllAccountsWithBalance(50).size()); // Should be 2 (Basic and Premium)

        // Try closing accounts
        System.out.println("\nAttempting to Close Accounts:");
        bank.CloseAccount(1); // Should print: Account cannot be closed due to debt
        bank.CloseAccount(2); // Should close successfully
        System.out.println("Total Accounts in Bank After Closure: " + bank.GetAllAccounts().size()); // Should be 2
    }
}
