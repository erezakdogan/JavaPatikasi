package SigortaSistemi;

import java.util.ArrayList;
import java.util.Scanner;

public class Individual extends Account {
    Scanner scan = new Scanner(System.in);
    public int mont;
    @Override
    public void insuranceAdd(ArrayList<Insurance> insurances) {
        System.out.println("Satın almak istediğiniz sigortayı seçiniz:\n"+"1 - Hayat Sigortası\n"+"2 - Konut Sigortası\n"+"3 - Seyehat Sigortası\n"+"4 - Araba Sigortası\n");
        int i = scan.nextInt();
        System.out.println("Ay : ");
        mont = scan.nextInt();        
        switch(i){
            case 1:
            HealthInsurance healthInsurance = new HealthInsurance();
            insurances.add(new HealthInsurance());
            healthInsurance.calculate(mont);
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
}
