package OnlineBank;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.HashMap;

public class User {
    private int tcNO;
    private int balance;
    private int creditDebt;
    private int cartDebt;
    private String name;
    private String pass;
    JSONObject jmain;


    public User(int tcNO, int balance, int creditDebt, int cartDebt, String name, String pass) {
        this.tcNO = tcNO;
        this.balance = balance;
        this.creditDebt = creditDebt;
        this.cartDebt = cartDebt;
        this.name = name;
        this.pass = pass;
        addUser(tcNO, balance, creditDebt, cartDebt, name, pass);
    }

    public int getTcNO() {
        return this.tcNO;
    }

    public void setTcNO(int tcNO) {
        this.tcNO = tcNO;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCreditDebt() {
        return this.creditDebt;
    }

    public void setCreditDebt(int creditDebt) {
        this.creditDebt = creditDebt;
    }

    public int getCartDebt() {
        return this.cartDebt;
    }

    public void setCartDebt(int cartDebt) {
        this.cartDebt = cartDebt;
    }
   

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void addUser(int tcNO, int balance, int creditDebt, int cartDebt, String name, String pass) {
        try {
            jmain = new JSONObject();
            FileReader f = new FileReader("OnlineBank/DataBase.json");
            BufferedReader br = new BufferedReader(f);
            JSONParser jsonParser = new JSONParser();
            jmain = (JSONObject) jsonParser.parse(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JSONArray jsonArray;
        if (!jmain.isEmpty()) {
            jsonArray = (JSONArray) jmain.get("employees");
        } else {
            jsonArray = new JSONArray();
        }

        HashMap<String, Object> employee = new HashMap<String, Object>();
        employee.put("tcNO", tcNO);
        employee.put("balance", balance);
        employee.put("creditDebt", creditDebt);
        employee.put("cartDebt", cartDebt);
        employee.put("name", name);
        employee.put("pass", pass);

        JSONObject jsonObject = new JSONObject(employee);
        jsonArray.add(jsonObject);
        jmain.put("employees", jsonArray);

        try (FileWriter file = new FileWriter("OnlineBank/DataBase.json")) {
            file.write(jmain.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(String tcNO, String key, Object value) {
        try {
            FileReader fileReader = new FileReader("OnlineBank/DataBase.json");
            BufferedReader br = new BufferedReader(fileReader);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
            JSONArray jsonArray = (JSONArray) jsonObject.get("employees");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
                if (tcNO.equals(jsonObject2.get("tcNO").toString())) {
                    jsonObject2.put(key, value);
                }
            }

            try (FileWriter file = new FileWriter("OnlineBank/DataBase.json")) {
                file.write(jsonObject.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }
}
