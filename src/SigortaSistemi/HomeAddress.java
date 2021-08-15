package SigortaSistemi;

public class HomeAddress implements Address {
    String street;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public HomeAddress(String street) {
        this.street = street;
    }

    @Override
    public void add(String street) { 
        
    }
   @Override
   public String getAddresse() { 
       return street;
   }
}
