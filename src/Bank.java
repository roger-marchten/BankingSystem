import java.util.ArrayList;
import java.util.List;

public class Bank implements iBank {
    private List<iAccounts> accounts;


    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(iAccounts account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        iAccounts accountToClose = findAccountByNumber(accountNumber);

        if (accountToClose == null) {
            return; // Ignore request if account not found
        }

        if (accountToClose.getCurrentBalance() < 0) {
            System.out.println("Account cannot be closed due to debt.");
        } else {
            accounts.remove(accountToClose);
        }
    }

    @Override
    public List<iAccounts> GetAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<iAccounts> GetAllAccountsInDebt() {
        List<iAccounts> inDebt = new ArrayList<>();
        for (iAccounts account : accounts) {
            if (account.getCurrentBalance() < 0) {
                inDebt.add(account);
            }
        }
        return inDebt;
    }

    @Override
    public List<iAccounts> GetAllAccountsWithBalance(double amount) {
        List<iAccounts> aboveThreshold = new ArrayList<>();
        for (iAccounts account : accounts) {
            if (account.getCurrentBalance() > amount) {
                aboveThreshold.add(account);
            }
        }
        return aboveThreshold;
    }

    /**
     * Finds an account by its account number.
     * @param accountNumber The account number to find.
     * @return The account if found; otherwise, null.
     */
    private iAccounts findAccountByNumber(int accountNumber) {
        for (iAccounts account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
