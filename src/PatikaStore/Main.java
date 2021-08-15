package PatikaStore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {    
 public static TreeMap<Integer,String> nMap = new TreeMap<>();
 static ArrayList<Handy> handy = new ArrayList<>();
 public static ArrayList<Notebook> notebooks = new ArrayList<>();
 public static ArrayList<Marka> markas = new ArrayList<>();
      static{
        nMap.put(1, "Samsung");
        nMap.put(2, "Lenovo");
        nMap.put(3, "Apple");
        nMap.put(4, "Huawei");
        nMap.put(5, "Casper");
        nMap.put(6, "Asus");
        nMap.put(7, "HP");
        nMap.put(8, "Xiaomi");
        nMap.put(9, "Monster"); 
      } 
      
    
      

      
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      handy.add( new Handy(1, 3199, 30, 128, 6, 30, 4000, "SAMSUNG GALAXY A51",new Marka(1, "Samsung"),"Siyah", 6.3));
      handy.add( new Handy(2, 7379, 40, 64, 6, 30, 3064, "iPhone 11 64 GB",new Marka(2, "Apple"),"Mavi", 6.3));
      handy.add( new Handy(3, 4012, 50, 128, 12, 30, 4000, "Redmi Note 10 Pro 8GB",new Marka(2, "Xiaomi"),"Beyaz", 6.3));

      notebooks.add(new Notebook(1, 7000, 35, 512, 16, 45, "HUAWEI Matebook 14", new Marka(1, "Huawei"), 14.0));
      notebooks.add(new Notebook(2, 3699, 45, 1024, 8, 55, "LENOVO V14 IGL", new Marka(1, "Lenovo"), 14.0));
      notebooks.add(new Notebook(3, 8199, 25, 2048, 32, 35, "ASUS Tuf Gaming", new Marka(1, "Asus"), 15.6));


      System.out.println("PatikaStore Ürün Yönetim Paneli !");
      System.out.println("1 - Notebook İşlemleri\n"+"2 - Cep Telefonu İşlemleri\n"+"3 - Marka Listele\n"+"4 - Ürün Ekleme\n"+"0 - Çıkış Yap");
      int secim = scan.nextInt();

      while(secim!=0){
        switch(secim){
          case 1:
          listNotebooks();
          System.out.println("\n1 - Oge sil ");
          System.out.println("9 - Ana Menü");
                int sel=scan.nextInt();
                 switch(sel){
                 case 1:
                 case 9:
                 break;
                 }
          
          break;


          case 2:
          listHandy();
          System.out.println("\n1 - Oge sil ");
          System.out.println("9 - Ana Menü");
         
                int sel2=scan.nextInt();
                switch(sel2){
                case 1:
                   System.out.println("\nSilinecek öğe Id'si giriniz : ");
                   int idHandy = scan.nextInt();
                   handy.remove(idHandy-1);
                break;
                case 2:
                
                break;
                case 9:
                break;
                }




         
         
          break;
          case 3:
          listBrands();

          break;
          case 4:
          System.out.println("|Type:Handy-Notebook |Id |FIYAT |INDIRIM |DEPOLAMA |RAM |STOK |PIL |ISIM |MARKA |RENK |EKRAN");
          addItem(scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.nextDouble());
          break;
          
        }
        System.out.println("\n9 - Ana Menü");
        secim = scan.nextInt();
        if(secim==9){
          System.out.println("1 - Notebook İşlemleri\n"+"2 - Cep Telefonu İşlemleri\n"+"3 - Marka Listele\n"+"4 - Ürün Ekleme\n"+"0 - Çıkış Yap");
          secim=scan.nextInt();
        }
        continue;
      }

    }


    public static void addItem(String type,int id, int birimFiyati, int indirimOrani, int depolama, int ram, int stok,int pil, String itemName,String marka,String renk,
    Double ekranDouble){
      if(nMap.containsValue(marka)){
      if(type.equalsIgnoreCase("Handy")){
        handy.add(new Handy(id,  birimFiyati,  indirimOrani,  depolama,  ram,  stok, pil,  itemName,new Marka(id,marka)  , renk,
      ekranDouble));
      }else{
        notebooks.add(new Notebook(id, birimFiyati, indirimOrani, depolama, ram, stok, itemName, new Marka(id,marka), ekranDouble));
      }
      }
     System.out.println("bitti");
    }

   

    
    public static void listBrands(){
      Comparator<Integer> valueComparator = new Comparator<Integer>()
      {
          public int compare(Integer k1, Integer k2)
          {

              int comp = nMap.get(k1).compareTo(nMap.get(k2));

              if (comp == 0)
                   return 1;

              else
                   return comp;
          }
      };
      Map<Integer, String> sorted = new TreeMap<Integer, String>(valueComparator);
      sorted.putAll(nMap);
      for(String s: sorted.values()){
        System.out.println(s);
      }
    } 
    public static void listHandy(){
       System.out.format("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-30s%-15s%-10s%-10s", "|Id","|FIYAT","|INDIRIM","|DEPOLAMA", "|RAM","|STOK","|PIL","|ISIM","|MARKA","|RENK","|EKRAN"); 
    
       for(Handy o : handy){
         System.out.println();
       System.out.format("%-10d%-10d%-10d%-10d%-10d%-10d%-10d%-30s%-15s%-10s%-10f", o.getId() ,o.getBirimFiyati(),o.getIndirimOrani(),o.getDepolama(), o.getRam(),o.getStok(),o.getPil(), o.getItemName(),o.getMarka().getName(),o.getRenk(),o.getEkranDouble()); 
       }
      }
      public static void listNotebooks(){
        System.out.format("%-10s%-10s%-10s%-10s%-10s%-10s%-30s%-15s%-10s", "|Id","|FIYAT","|INDIRIM","|DEPOLAMA", "|RAM","|STOK","|ISIM","|MARKA","|EKRAN"); 
     
        for(Notebook o : notebooks){
          System.out.println();
        System.out.format("%-10d%-10d%-10d%-10d%-10d%-10d%-30s%-15s%-10f", o.getId() ,o.getBirimFiyati(),o.getIndirimOrani(),o.getDepolama(), o.getRam(),o.getStok(), o.getItemName(),o.getMarka().getName(),o.getEkranDouble()); 
         
       }
    
    }
    
}
