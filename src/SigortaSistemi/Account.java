package SigortaSistemi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public abstract class Account {
    boolean login = true;
    AccountManager accountManager = new AccountManager();
    ArrayList<Insurance> insurances = new ArrayList<>();
   
    User user = new User("Individual","Erez", "Akdogan", "erezakdogan.ea@gmail.com", "Password4insurance", "Software Dev.", 21, new ArrayList<Address>() , new Date(1999-1900,11,18));
    
    AddressManager addressManager = new AddressManager(user);

    
    
    public void authenticationStatus(){
        enum state{
                FAIL,
                SUCCESS
        }
        try{
            accountManager.login(user,user.getEmail(), user.getPassword());
        }catch(InvalidAuthenticationException e){
        System.err.print(e);
        System.out.println("Login : "+state.FAIL);
        login = false;
        }
    
        if(login){
            System.out.println("Login : "+state.SUCCESS);
            afterLogin();
        }
        
        

        
    }
    
    public abstract void insuranceAdd(ArrayList<Insurance> insurances);

    public void listInsurance(){
        for(Insurance insurance: insurances){
            System.out.println(insurance.getPlanName()+" Price: "+insurance.getPlanPrice());
        }
    }
    public final void showUserInfo(){
        
        System.out.println(
        "Account Type: "+user.getAccountType()+
        "\nName: "+user.getName()+
        "\nSurname: "+user.getSurName()+
        "\nEmail: "+user.getEmail()+
        "\nJob: "+user.getJob()+
        "\nAge: "+user.getAge()+
        "\nAddress: "+user.getAddresse()+
        "\nLast Login:"+user.getLastLogin());
    }
    public void afterLogin(){
        Scanner scan = new Scanner(System.in);
        Individual individual = new Individual();
        System.out.println(
        "\nHoşgeldiniz"+
        "\n1-Kullanıcı Bilgileri "+
        "\n2-Sigortalarım");
        int sel = scan.nextInt();
        while(sel!=0){

        switch(sel){
            case 1:
            showUserInfo();
            System.out.println("1-Adres ekle"+"\n2-Adres çıkar"+"\n0-Çıkış yap");
            switch(scan.nextInt()){
                case 1:
                addressManager.add();
                continue;
                case 2:
                addressManager.delete();
                continue;
                case 0:
                afterLogin();
                break;
            }
            break;
            case 2:
            listInsurance();
            System.out.println("1-Sigorta satın al"+"\n0-Çıkış yap");
            int b= scan.nextInt();
            switch(b){
                case 1:
                if(user.getAccountType().startsWith("E")){
                    Enterprise enterprise = new Enterprise();
                    enterprise.insuranceAdd(insurances);
                    break;
                }else{
                    individual.insuranceAdd(insurances);
                }

                break;
                case 0:
                afterLogin();
                break;
            }
        }  
        sel = scan.nextInt(); 
        System.out.println(
        "\nHoşgeldiniz"+
        "\n1-Kullanıcı Bilgileri "+
        "\n2-Sigortalarım");
        }
    
    }
}
