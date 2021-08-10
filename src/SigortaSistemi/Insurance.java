package SigortaSistemi;

import java.util.Date;

public abstract class Insurance {
    String planName;
    double planPrice;
    Date planValidDate;
    Account account;
    public User getUser() {
        return account.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    User user;
    
    public abstract double calculate(int month);

    public String getPlanName() {
        return getClass().getSimpleName();
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPlanPrice() {
        return this.planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }

    public Date getPlanValidDate() {
        return this.planValidDate;
    }

    public void setPlanValidDate(Date planValidDate) {
        this.planValidDate = planValidDate;
    }
 }
