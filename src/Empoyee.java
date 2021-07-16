package src;

public class Empoyee {   
    static String name="kemal";      //:Çalışanın adı ve soyadı
    static int salary= 2000;       //:Çalışanın maaşı
    static int workHour=45;     //:Haftalık çalışma saati
    static int hireYear=1985;     //:İşe başlangıç yılı

    public static void main(String[] args) {
        toString(name, salary, workHour, hireYear);
    }

    void Employee(String name,int salary,int workHour,int hireYear){     //: Kurucu metot olup 4 parametre alacaktır.

    }

    public static int tax(int salary){      //: Maaşa uygulanan vergiyi hesaplayacaktır
        // Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
        // Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
        int taxes = 0;
        if(salary>=1000){
          taxes=salary/100*3;
        }
       return taxes;
    }

    public static int bonus(int salary, int workHour){  
        //: Haftada 40 saatten fazla çalışıldığında saat başına 30 TL olacak şekilde maaşa uygulanacak
        int bonWh = workHour-40;
        int bon = 0;
         if(bonWh>0){
            bon =bonWh*30;
         }
        return bon;
    } 
    public static int raiseSalary(int hireYear, int salary){
        // Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
        // Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
        // Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
        // Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
        int workedYear = 2021-hireYear;
        int raiseS=0;
        if(workedYear<10){
            raiseS += salary*0.05;
        }else if(workedYear>9 && workedYear<20){
            raiseS+= salary*0.1;
        }else if(workedYear>19){
            raiseS+= salary*0.15;
        }
        return raiseS;
    } 

    public static void toString(String name,int salary,int workHour,int hireYear){  //: Çalışana ait bilgileri ekrana bastıracaktır
        System.out.print(
        "Adı : "+name+
        "\nMaaşı : "+salary+
        "\nÇalışma Saati : "+workHour+
        "\nBaşlangıç Yılı : "+hireYear+
        "\nVergi : "+ tax(salary)+
        "\nBonus : "+ bonus(salary,workHour)+
        "\nMaaş Artışı : "+raiseSalary(hireYear, salary)+
        "\nVergi ve Bonuslar ile birlikte maaş : " + (
        bonus(salary,workHour)-tax(salary))+
        "\nToplam Maaş : "+((salary+(
            bonus(salary,workHour)-tax(salary)))+raiseSalary(hireYear, salary)));
    } 

}
