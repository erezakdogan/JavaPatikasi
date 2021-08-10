package SigortaSistemi;

public class TravelInsurance extends Insurance {

    @Override
    public double calculate(int month) {
        double price;
        if(user.getAccountType().startsWith("E")){
            price= month*5.5;
        }else{
            price= month*9.5;
        }
        setPlanPrice(price);
        return price;   
    }
    
}
