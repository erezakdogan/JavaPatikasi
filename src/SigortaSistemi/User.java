package SigortaSistemi;

import java.util.*;
import java.util.ArrayList;

public class User implements Address {
    AddressManager addressManager;
    private String accountType,name,surName,email,password,job;

    
    private int age;
    private ArrayList<Address> addresses;
    private Date lastLogin;
 

    public User(String accountType, String name, String surName, String email, String password, String job, int age, ArrayList<Address> addresses, Date lastLogin) {
        this.accountType = accountType;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addresses = addresses;
        this.lastLogin = lastLogin;
    }  
@Override
public void add(String street) {
    addresses.add(new BusinessAddress(street));
    
}


    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
 
@Override
public String getAddresse() {
    String str = "";
    for(Address address : addresses){
         str +=address.getAddresse()+" ";
    }
   return str;
}
}
