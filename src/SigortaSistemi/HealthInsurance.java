package SigortaSistemi;


public class HealthInsurance extends Insurance {
   double price;

  @Override
  public void setPlanPrice(double planPrice) {
      super.setPlanPrice(planPrice);
  }
  @Override
  public double getPlanPrice() {
      return super.getPlanPrice();
  }
    @Override
    public double calculate(int month) {
        if(user.getAccountType().startsWith("E")){
            price= month*12.5;
        }else{
            price= month*14.5;
        }        
        setPlanPrice(price);
        
        return price;   
    }

}
