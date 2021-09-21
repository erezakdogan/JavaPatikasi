package OnlineBank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BankManagement {
    static boolean authenticate = false;
    static Scanner scanner = new Scanner(System.in);
    static JSONObject userJson;

    public static void main(String[] args) {
        getJsonFile();
        selectAction();
        login();

        // User user = new User(0, 0, 0, 0, null, "sfd");
        // user.addUser(0, 0, 0, 0, null, "1234");
    }

    private static void selectAction() {
        System.out.println("1.Giriş Yap\n2.Kaydol");
        int selection = scanner.nextInt();
        switch(selection){
            case 1:
            login();
            break;
            case 2:
            addUser();
            break;
        }
    }

    private static void addUser() {
        
    }

    private static void login() {
        System.out.println("T.C. KİMLİK NO : ");
        String tcNO = scanner.next();
        System.out.println("ŞİFRE : ");
        String pass = scanner.next();

        int attemtCount = 3;
        while (authenticate || attemtCount > 0) {
            if (authenticate(tcNO, pass)) {
                onlineTransactions(tcNO);
            }
            attemtCount--;
        }
    }

    private static void onlineTransactions(String tcNO) {
        String selections = "1.Para Transferi \n2.Ödemeler\n3.Ana Menü\n0.Çıkış Yap\nSeçim Yap";
        int selection = -1;
        do {
            System.out.println(selections);
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    sendMoney(tcNO);
                    break;
                case 2:
                    payments(tcNO);
                    break;
                case 0:
                    selection = 0;
                    break;
            }
            selection = scanner.nextInt();

        } while (selection != 0);
    }

    private static void sendMoney(String tcNO) {
        String paymentSection = "Alıcının T.C. Kimlik Numarasını Giriniz : ";
        System.out.println(paymentSection);
        String reciverTC = scanner.next();
        boolean notExists = true;
        for (int i = 0; i < getJsonFile().size(); i++) {
            JSONObject jsonObject = (JSONObject) getJsonFile().get(i);
            if (reciverTC.contains(jsonObject.get("tcNO").toString())) {
                System.out.println("Göndermek istediğiniz tutarı giriniz : ");
                int amount = scanner.nextInt();
                notExists = false;
                if (amount < Integer.parseInt(getUserJson(tcNO).get("balance").toString())) {
                    JSONObject receiver = (JSONObject) getJsonFile().get(i);
                    int finBalance = Integer.parseInt(receiver.get("balance").toString()) + amount;
                    User.updateUser(reciverTC, "balance", finBalance);

                    // if (tcNO.contains(userJson.get("tcNO").toString())) {
                    int finBalanceSender = Integer.parseInt(getUserJson(tcNO).get("balance").toString()) - amount;
                    User.updateUser(tcNO, "balance", finBalanceSender);
                    // break;
                    // }
                    break;
                }
                break;
            }
        }
        if (notExists) {
            System.out.println("T.C. NUMARASI YANLIŞ TEKRAR DENEYİNİZ!");
        }
    }

    private static void payments(String tcNO) {
        int selection = -1;
        while (selection != 3) {        
            System.out.println("1.Kredi Ödemesi\n2.Kredi Kartı Ekstresi\n3.Ana Menü\nSeçim Yapınız.");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    if (getUserJson(tcNO).get("creditDebt").equals(0)) {
                        System.out.println("Borcunuz Bulunmamaktadır.\n0.Çıkış");
                        selection = scanner.nextInt();
                    } else {
                        System.out.println(
                                "Mevcut Borcunuz : " + getUserJson(tcNO).get("creditDebt") + "\nÖdemek istediğiniz tutar : ");
                        int amount = scanner.nextInt();
                        if (0 < Integer.parseInt(getUserJson(tcNO).get("balance").toString())-amount) {
                            int finDebt = Integer.parseInt(getUserJson(tcNO).get("creditDebt").toString()) - amount;
                            User.updateUser(tcNO, "creditDebt", finDebt);
                            System.out.println(finDebt);
                            User.updateUser(tcNO, "balance", (Integer.parseInt(getUserJson(tcNO).get("balance").toString()) - amount));
                        } else {
                            System.out.println("Hesabınızda giridiğiniz değerde bakiye bulunmamaktadır.");
                        }
                    }
                    break;
                case 2:
                    if (getUserJson(tcNO).get("cartDebt").equals(0)) {
                        System.out.println("Borcunuz Bulunmamaktadır.\n0.Çıkış");
                        selection = scanner.nextInt();
                    } else {
                        System.out.println(
                                "Mevcut Borcunuz : " + getUserJson(tcNO).get("cartDebt") + "\nÖdemek istediğiniz tutar : ");
                        int amount = scanner.nextInt();
                        if (0 < Integer.parseInt(getUserJson(tcNO).get("balance").toString())-amount) {
                            int finDebtc = Integer.parseInt(getUserJson(tcNO).get("cartDebt").toString()) - amount;
                            User.updateUser(tcNO, "cartDebt", finDebtc);
                            User.updateUser(tcNO, "balance", (Integer.parseInt(getUserJson(tcNO).get("balance").toString()) - amount));
                        } else {
                            System.out.println("Hesabınızda giridiğiniz değerde bakiye bulunmamaktadır.");
                        }
                    }
                    break;
                default :
                    System.out.println("Geçersiz Bir Seçim Yaptınız Tekrar Deneyiniz.");
                    break;
            }
        }
    }

    private static boolean authenticate(String tcNO, String pass) {
        for (int i = 0; i < getJsonFile().size(); i++) {
            JSONObject jsonObject = (JSONObject) getJsonFile().get(i);
            if (jsonObject.get("tcNO").toString() == tcNO || jsonObject.get("pass").equals(pass)) {
                authenticate = true;
                userJson = (JSONObject) getJsonFile().get(i);
            } else {
                System.out.println("ŞİFRE YA DA T.C. NUMARASI YANLIŞ TEKRAR DENEYİNİZ!");
            }
        }
        return authenticate;

    }

    private static JSONArray getJsonFile() {
        JSONArray jsonArray = new JSONArray();
        try {
            FileReader file = new FileReader("OnlineBank/DataBase.json");
            BufferedReader br = new BufferedReader(file);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
            jsonArray = (JSONArray) jsonObject.get("employees");
            return jsonArray;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return jsonArray;
    }
    private static JSONObject getUserJson(String tcNO){
       for(int i = 0 ; i<getJsonFile().size();i++){
           JSONObject jsonObject = (JSONObject) getJsonFile().get(i);
           if(tcNO.equals(jsonObject.get("tcNO").toString())){
               return jsonObject;
           }
       }
        return null;
    }

}