package StarjanProject.Digital_Payment_Platform_App.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;

import java.util.HashMap;

public class NpUser_Data {
    private static List<User> holders = new ArrayList<>();
    private static Map<Integer, MapAccount> userBankAccount_credetials = new HashMap<>();
    
    // Add Holders using user inout
    public static void addHolders(User sign) {
        String password = ExceptionHandling.string("Confirm Password : ");
        while (true) {
            if (password.equalsIgnoreCase(sign.getPassword())) {
                    holders.add(sign);
                    NpUser_Data.mapBankAccount_credentials(sign.getUserId(), new MapAccount(sign.getUserId()));
                    return;
            }
            else{
                System.out.println("Confirm password mismatch");
                password = ExceptionHandling.string("ReEnter confirm password : ");
            }
        }
        
    }

    // Add Holders manually
    public static void addHoldersmanual(User sign) {
        holders.add(sign);
        
    }


    // Gettter
    public static List<User> getHolders() {
        return holders;
    }

    public static void setTempHolder(User sign) {
        holders.add(sign);
    }

    // View Holders
    public static void showHolders() {
        
        for (User signUp : holders) {
            System.out.print("[ ");
            System.out.print("Name : " + signUp.getName() + " | Ph.No : " + signUp.getPhoneNumber() + " | MailID : " + signUp.getMailId() + " | UserId: " + signUp.getUserId() + " | Password: " + signUp.getPassword());
            System.out.print(" ]");
            System.out.println();
        }
        
    }


    // Create Bank Account credentials
    public static void mapBankAccount_credentials(int id, MapAccount acc) {
        userBankAccount_credetials.put(id, acc);
    }
    
    // Getter
    public static Map<Integer, MapAccount> getUserBankAccount_credetials() {
        return userBankAccount_credetials;
    }
    
    // View Bank Credentials
    public static void showAccountCredentials() {
        
        for (Map.Entry<Integer, MapAccount> acc : userBankAccount_credetials.entrySet()) {
            int id = acc.getKey();
            String accNo = acc.getValue().getAccountNum();
            String ifsc = acc.getValue().getIfscCode();
            System.out.print("[");
            System.out.print("UserID: " + id + "\tAcc Id: " + acc.getValue().getAccId() + "\tAccount Number:" + accNo + "\tIFSC Code: " + ifsc + "\tUpin: " + acc.getValue().getUpin() + "\tUpiId: " + acc.getValue().getUpiId());
            System.out.print("]");
            System.out.println();
        }
        
    }

    // Is account already mapped
    public static boolean isAccountMapped(String accno, String ifsc) {
        for (MapAccount ma : userBankAccount_credetials.values()) {
            if (ma.getAccountNum().equals(accno) && ma.getIfscCode().equals(ifsc)) {
                return true;
            }
        }
        return false;
    }
    
    
}
