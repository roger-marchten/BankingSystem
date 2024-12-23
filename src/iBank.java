import java.util.List;

public interface iBank {

    void OpenAccount(iAccounts account);

    void CloseAccount(int accountNumber);

    List<iAccounts> GetAllAccounts();
    List<iAccounts> GetAllAccountsInDebt();
    List<iAccounts> GetAllAccountsWithBalance(double amount);
}
