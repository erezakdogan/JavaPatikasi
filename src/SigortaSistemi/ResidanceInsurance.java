package SigortaSistemi;

public class ResidanceInsurance extends Insurance {
    double tot;
    @Override
    public double calculate(int month) {
        double a;
        if(user.getAccountType()=="Individual"){
            a=3.5;
        }else{
            a=3.25;
        }
        tot = month*a;
        setPlanPrice(tot);
    return tot;
}
    
}
