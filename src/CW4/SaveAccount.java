package CW4;

public class SaveAccount extends Account {

    private float interestRatePercentage = 10;

    public SaveAccount(User user){
        super(user);
    }

    public void setInterestRatePercentage(float interestRatePercentage) {
        this.interestRatePercentage = interestRatePercentage;
    }

    public void applyInterestToBalance() {
        this.balance += this.balance * this.interestRatePercentage / 100;
    }
}
