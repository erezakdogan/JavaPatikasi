package SigortaSistemi;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressManager {
    Scanner scan = new Scanner(System.in);
    User user;

    public AddressManager(User user) {
        this.user = user;
    }

    public void add(){
    System.out.println("(B)usiness or (H)ome");
    if(scan.next().startsWith("B")){
        user.getAddresses().add(new BusinessAddress(scan.next()));
        
    }else{
        user.getAddresses().add(new HomeAddress(scan.next()));
    }
   
    }
    public void delete(){
    //     for(Address a : user.getAddresses()){
    //         if(user.getAddresse().contains("is")){
    //             user.getAddresses().contains(a);
    //         }
    //     }
    //   System.out.println(user.getAddresses().size());  
    }
    
}
