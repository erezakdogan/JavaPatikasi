package PatikaStore;

import java.util.ArrayList;

public class Devices {
    int id,birimFiyati,indirimOrani,depolama,ram, stok;
    String itemName;
    Double ekranDouble;
    Marka marka;

    

    public Devices(int id, int birimFiyati, int indirimOrani, int depolama, int ram, int stok, String itemName,Marka marka, Double ekranDouble) {
        this.id = id;
        this.birimFiyati = birimFiyati;
        this.indirimOrani = indirimOrani;
        this.depolama = depolama;
        this.ram = ram;
        this.stok = stok;
        this.itemName = itemName;
        this.marka = marka;
        this.ekranDouble = ekranDouble;
    }

   

    public Marka getMarka() {
        return this.marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBirimFiyati() {
        return this.birimFiyati;
    }

    public void setBirimFiyati(int birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public int getIndirimOrani() {
        return this.indirimOrani;
    }

    public void setIndirimOrani(int indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public int getDepolama() {
        return this.depolama;
    }

    public void setDepolama(int depolama) {
        this.depolama = depolama;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getEkranDouble() {
        return this.ekranDouble;
    }

    public void setEkranDouble(Double ekranDouble) {
        this.ekranDouble = ekranDouble;
    }
}
