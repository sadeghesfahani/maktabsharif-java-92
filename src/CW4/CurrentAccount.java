package CW4;

public class CurrentAccount extends Account{
    private float draftLimit = 1000000;

    public CurrentAccount(User user) {
        super(user);
    }

    public void UpdateDraftLimit(float value){
        this.draftLimit = value;
    }



    @Override
    public boolean widthraw(float value) {
        if(this.balance - value >  this.draftLimit){
            this.balance -=value;
            return true;
        }
        return false;
    }

    public boolean isOverDraftLimit(){
        return this.balance < 0;
    }

    public void update(){
        if(this.isOverDraftLimit()){
            System.out.println(this.user.getName() + "is over drafted");
        };
    }
}
