package CW4;

public abstract class Account {
    protected float balance;
    protected User user;


    public Account(User user){
        this.user = user;
    }

    public boolean widthraw(float value) {
        if (balance - value > 0) {
            this.balance -= value;
            return true;
        }
        return false;
    }

    public float deposit(float value) {
        this.balance += value;
        return this.balance;
    }





}


