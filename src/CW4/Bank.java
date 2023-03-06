package CW4;

public class Bank {
    private Account[] accounts;

    public void createAccount(String name, String nationalId, String accountType) {
        User user = new User(name, nationalId);
        Account account;
        if (accountType.equals("current")) {
            account = new CurrentAccount(user);
        } else {
            account = new SaveAccount(user);
        }
        addAccountToTheList(account);
    }

    public void update(){
        for (Account account:
             this.accounts) {
//            account.upda
        }
    }

    private void addAccountToTheList(Account account) {
        Account[] newAccounts = new Account[this.accounts.length + 1];
        System.arraycopy(this.accounts, 0, newAccounts, 0, accounts.length);
        newAccounts[this.accounts.length] = account;
    }
}
