package Threads;

import java.util.ArrayList;

public class Threadscomp implements Runnable{
    private int id ;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> fulList = new ArrayList<>();
    public static ArrayList<Integer> doublIntegers = new ArrayList<>();
    static ArrayList<Integer> singleIntegers = new ArrayList<>();

       Threadscomp(int id){
           this.id=id;
       };    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
  @Override
  public synchronized void run() {
     
        for(int k = 1 ; k<=4; k++){
            if(k==this.id){
                for(Integer s : lists.get(k-1)){
               if(s%2==0){
                 System.out.println(Thread.currentThread().getName()+ " : "+s+" double");
                 doublIntegers.add(s);
                 
             }else{
                System.out.println(Thread.currentThread().getName()+ " : "+s+" single");
                 singleIntegers.add(s);
                }   
            }
        }
      }
    }
{
    for(int i = 1; i<=10000;i++){
    fulList.add(i);
    }

    for(int j=0;j<4;j++){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(fulList.subList(j+2500*j, 2500*(j+1)));
        lists.add(arrayList);
    }
}
}

     

