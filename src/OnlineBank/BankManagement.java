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
    static org.json.JSONObject userJson;

    public static void main(String[] args) {
        getJsonFile();
        login();
        // User user = new User(0, 0, 0, 0, null, "sfd");
        // user.addUser(0, 0, 0, 0, null, "1234");
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
        int selection;
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
                    break;
            }

        } while (selection != 0);
    }

    private static void payments(String tcNO) {
        String paymentSection = "Alıcının T.C. Kimlik Numarasını Giriniz : ";
        System.out.println(paymentSection);
        String reciverTC = scanner.next();
        for (int i = 0; i < getJsonFile().size(); i++) {
            JSONObject jsonObject = (JSONObject) getJsonFile().get(i);

            if ((boolean) jsonObject.get(("tcNo").equals(reciverTC))) {
                System.out.println("Göndermek istediğiniz tutarı giriniz : ");
                float amount = scanner.nextFloat();
                if (amount < userJson.getFloat("balance")) {
                    org.json.JSONObject receiver = (org.json.JSONObject) getJsonFile().get(i);
                    receiver.put("balance", (float) receiver.get("balance") + amount);

                    for (int j = 0; j < getJsonFile().size(); j++) {
                        org.json.JSONObject jsonObject2 = (org.json.JSONObject) getJsonFile().get(j);
                        if (jsonObject2.get("tcNo") == tcNO) {
                            org.json.JSONObject sender = jsonObject2;
                            sender.put("balance", (float) receiver.get("balance") - amount);
                        }
                    }
                }

            } else {
                System.out.println("T.C. NUMARASI YANLIŞ TEKRAR DENEYİNİZ!");
            }

        }
    }

    private static void sendMoney(String tcNO) {
    }

    private static boolean authenticate(String tcNO, String pass) {
        System.out.println(tcNO + " " + pass);
        System.out.println(getJsonFile().size());
        for (int i = 0; i < getJsonFile().size(); i++) {
            JSONObject jsonObject = (JSONObject) getJsonFile().get(i);
            if (jsonObject.get("tcNO").toString() == tcNO && jsonObject.get("pass").equals(pass)) {
                authenticate = true;
                System.out.println("autenticated");
                userJson = (org.json.JSONObject) getJsonFile().get(i);
            } else {
                System.out.println("ŞİFRE YA DA T.C. NUMARASI YANLIŞ TEKRAR DENEYİNİZ!");
            }
        }
        return authenticate;

    }

    private static org.json.simple.JSONArray getJsonFile() {
        System.out.println("jsonArray.get(2).toString()");

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

}