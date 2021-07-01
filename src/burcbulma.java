package src;

import java.util.Scanner;

public class burcbulma {
    public static void main(String[] args) {
        int day, month;
        Scanner scan = new Scanner(System.in);

        System.out.print("Doğduğunuz ay(Rakam cinsiden) : ");
        month = scan.nextInt();
        System.out.print("Doğduğunuz gün(Rakam cinsiden) : ");
        day = scan.nextInt();


        if(month == 1){
            if(day<22){
                System.out.print("Burcunuz : Oğlak ");
            } else{
                System.out.print("Burcunuz : Kova ");
            }
        }else if(month == 2){
            if(day<20){
                System.out.print("Burcunuz : Kova ");
            } else{
                System.out.print("Burcunuz : Balık  ");
            }
        }else if(month == 3){
            if(day<21){
                System.out.print("Burcunuz : Balık");
            } else{
                System.out.print("Burcunuz : Koç ");
            }
        }else if(month == 4){
            if(day<21){
                System.out.print("Burcunuz : Koç ");
            } else{
                System.out.print("Burcunuz : Boğa ");
            }
        }else if(month == 5){
            if(day<22){
                System.out.print("Burcunuz : Boğa ");
            } else{
                System.out.print("Burcunuz : İkizler ");
            }
        }else if(month == 6){
            if(day<23){
                System.out.print("Burcunuz : İkizler ");
            } else{
                System.out.print("Burcunuz : Yengeç ");
            }
        }else if(month == 7){
            if(day<23){
                System.out.print("Burcunuz : Yengeç  ");
            } else{
                System.out.print("Burcunuz : Aslan  ");
            }
        }else if(month == 8){
            if(day<23){
                System.out.print("Burcunuz : Aslan  ");
            } else{
                System.out.print("Burcunuz : Başak  ");
            }
        }else if(month == 9){
            if(day<23){
                System.out.print("Burcunuz : Başak  ");
            } else{
                System.out.print("Burcunuz : Terazi  ");
            }
        }else if(month == 10){
            if(day<23){
                System.out.print("Burcunuz : Terazi  ");
            } else{
                System.out.print("Burcunuz : Akrep  ");
            }
        }else if(month == 11){
            if(day<22){
                System.out.print("Burcunuz : Akrep  ");
            } else{
                System.out.print("Burcunuz : Yay  ");
            }
        }else if(month == 12){
            if(day<22){
                System.out.print("Burcunuz : Yay  ");
            } else{
                System.out.print("Burcunuz : Oğlak  ");
            }
        }
    }
}
