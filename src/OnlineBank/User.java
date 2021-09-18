package OnlineBank;
public class User {
    private float tcNO;
    private float balance;
    private float creditDebt;
    private float cartDebt;
    private String name;
    

    public User(float tcNO, float balance, float creditDebt, float cartDebt, String name) {
        this.tcNO = tcNO;
        this.balance = balance;
        this.creditDebt = creditDebt;
        this.cartDebt = cartDebt;
        this.name = name;
    }
    
    public float getTcNO() {
        return this.tcNO;
    }

    public void setTcNO(float tcNO) {
        this.tcNO = tcNO;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditDebt() {
        return this.creditDebt;
    }

    public void setCreditDebt(float creditDebt) {
        this.creditDebt = creditDebt;
    }

    public float getCartDebt() {
        return this.cartDebt;
    }

    public void setCartDebt(float cartDebt) {
        this.cartDebt = cartDebt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addUser(float tcNO, float balance, float creditDebt, float cartDebt, String name){
        User user = new User(tcNO, balance, creditDebt, cartDebt, name);
        
    }
    
}
