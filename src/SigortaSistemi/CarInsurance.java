package SigortaSistemi;

public class CarInsurance extends Insurance {
    @Override
    public double calculate(int month) {
        double price;
        if(user.getAccountType().startsWith("E")){
            price= month*7.5;
        }else{
            price= month*9.5;
        }
        setPlanPrice(price);
        return price;   
    }
}
