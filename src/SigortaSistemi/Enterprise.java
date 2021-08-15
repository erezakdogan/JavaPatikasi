package SigortaSistemi;

import java.util.ArrayList;
import java.util.Scanner;

public class Enterprise extends Account { 
    
    Scanner scan = new Scanner(System.in);
    @Override
    public void insuranceAdd(ArrayList<Insurance> arrayList) {
            System.out.println("Satın almak istediğiniz sigortayı seçiniz:\n"+"1 - Hayat Sigortası\n"+"2 - Konut Sigortası\n"+"3 - Seyehat Sigortası\n"+"4 - Araba Sigortası\n");
            int i = scan.nextInt();
            System.out.println("Ay : ");
 
            switch(i){
                case 1:
                System.out.println(insurances.size());
                insurances.add(new HealthInsurance());
                System.out.println(insurances.size());
                break;
                case 2:
                insurances.add(new ResidanceInsurance());
                break;
                case 3:
                insurances.add(new TravelInsurance());
                break;
                case 4:
                insurances.add(new CarInsurance());
                break;
            
        }
    }
    public void getPrice(){
        for(Insurance i : insurances){
            i.calculate(3);
        }
    }
   
}
