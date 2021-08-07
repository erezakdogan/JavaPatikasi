package PatikaStore;


public class Handy extends Devices {
    String renk;
    int pil;
    public Handy(int id, int birimFiyati, int indirimOrani, int depolama, int ram, int stok,int pil, String itemName, Marka marka,String renk,
            Double ekranDouble) {
        super(id, birimFiyati, indirimOrani, depolama, ram, stok, itemName, marka, ekranDouble);
        this.renk=renk;
        this.pil=pil;

       
    }
    
    public String getRenk() {
        return this.renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getPil() {
        return this.pil;
    }

    public void setPil(int pil) {
        this.pil = pil;
    }
    public void add(int id, int birimFiyati, int indirimOrani, int depolama, int ram, int stok,int pil, String itemName,String renk,
    Double ekranDouble){
    //    Handy( id,  birimFiyati,  indirimOrani,  depolama,  ram,  stok, pil,  itemName, renk,
    //      ekranDouble);
    }

   
    
}
