package SigortaSistemi;


public class AccountManager implements Comparable {
   
    public void login(User user, String email, String password) throws InvalidAuthenticationException{
        if((user.getEmail()!=email)||(user.getPassword()!=password)){
           throw new InvalidAuthenticationException("Error ");
        }
    }




    @Override
    public int compareTo(Object o) {
        
        return 0;
    }
 }
