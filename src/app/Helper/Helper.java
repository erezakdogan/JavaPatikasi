package app.Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
    public static void showMsg(String s){
        switch(s){
            case "fill":
            JOptionPane.showMessageDialog(null, "Boşlukları Doldurunuz ", "Kullanıcı Ekleme İşlemi", JOptionPane.ERROR_MESSAGE);
            UIManager.put("OptionPane.okButtonText", "TAMAM");
            break;
            case "success":
            JOptionPane.showMessageDialog(null, "İşlem Başarılı ", "Kullanıcı Ekleme İşlemi", JOptionPane.INFORMATION_MESSAGE);
            UIManager.put("OptionPane.okButtonText", "TAMAM");
            break;
            case "reuname":
            JOptionPane.showMessageDialog(null, "İşlem Başarısız\nKullanıcı adı daha önce girilmiş ", "Kullanıcı Ekleme İşlemi", JOptionPane.ERROR_MESSAGE);
            UIManager.put("OptionPane.okButtonText", "TAMAM");
            break;
            case "invalid":
            JOptionPane.showMessageDialog(null, "İşlem Başarısız\nGeçersiz değer ", "Kullanıcı Ekleme İşlemi", JOptionPane.ERROR_MESSAGE);
            UIManager.put("OptionPane.okButtonText", "TAMAM");
            break;
            default : 
            JOptionPane.showMessageDialog(null, s, "Kullanıcı Ekleme İşlemi", JOptionPane.INFORMATION_MESSAGE);
            UIManager.put("OptionPane.okButtonText", "TAMAM");
            break;
        }
    }
}
