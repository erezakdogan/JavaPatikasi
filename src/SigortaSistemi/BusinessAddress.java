package SigortaSistemi;

public class BusinessAddress implements Address {
String street;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BusinessAddress(String street) {
        this.street = street;
    }

    @Override
    public void add(String street) {
        
    }

    @Override
    public String getAddresse() {
        
        return getStreet();
    }
   
    
}
