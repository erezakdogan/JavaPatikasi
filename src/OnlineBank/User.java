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
    private float tcNO;
    private float balance;
    private float creditDebt;
    private float cartDebt;
    private String name;
    private String pass;
    JSONObject jmain;

    public User(float tcNO, float balance, float creditDebt, float cartDebt, String name, String pass) {
        this.tcNO = tcNO;
        this.balance = balance;
        this.creditDebt = creditDebt;
        this.cartDebt = cartDebt;
        this.name = name;
        this.pass = name;
    }

    public float getTcNO() {
        return this.tcNO;
    }

    public void setTcNO(float tcNO) {
        this.tcNO = tcNO;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditDebt() {
        return this.creditDebt;
    }

    public void setCreditDebt(float creditDebt) {
        this.creditDebt = creditDebt;
    }

    public float getCartDebt() {
        return this.cartDebt;
    }

    public void setCartDebt(float cartDebt) {
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

    public void addUser(float tcNO, float balance, float creditDebt, float cartDebt, String name, String pass) {
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
