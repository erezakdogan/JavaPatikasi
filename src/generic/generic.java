package generic;

public class generic {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        System.out.println("2. indisteki değer : " + liste.get(2));


        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));
        
        MyList<Integer> subList = liste.sublist(3, 5);
        System.out.println(subList.toString());

        System.out.println("Listemde 20 değeri : " + (liste.isContains(20)?"Bulunmaktadır":"BULUNMAMAKTADIR"));
        System.out.println("Listemde 120 değeri : " + (liste.isContains(120)?"Bulunmaktadır":"BULUNMAMAKTADIR"));

        liste.clear();
        System.out.println(liste.toString());
    }
}
