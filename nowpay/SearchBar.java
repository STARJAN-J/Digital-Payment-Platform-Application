package StarjanProject.Digital_Payment_Platform_App.nowpay;

import java.util.Map;

import StarjanProject.Digital_Payment_Platform_App.authentication.MapAccount;
import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.authentication.User;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;

public class SearchBar {
    
    public static int searchBycontacts_Friends(String contact_Friend) {
        for (int i = 0; i < AccountHoldersDirectory.getAccHolders().size(); i++) {
            String contacts_Friends = AccountHoldersDirectory.getAccHolders().get(i).getName();
            if (contacts_Friends.equalsIgnoreCase(contact_Friend)) {
                return AccountHoldersDirectory.getAccHolders().get(i).getAccId();
            }
        }
        return 0;
    }

    public static int searchByupiId(String upiId) {
        
        for (Map.Entry<Integer, MapAccount> acc :  NpUser_Data.getUserBankAccount_credetials().entrySet()) {
            String upi = acc.getValue().getUpiId();
            if (upiId.equalsIgnoreCase(upi)) {
                return acc.getValue().getAccId();
            }            
        }
        return 0;
    }

    public static int searchBymobileNos(String mobileNo) {
        for (User user : NpUser_Data.getHolders()) {
            int userId = user.getUserId();
            if (user.getPhoneNumber().equals(mobileNo)) {
                int recieverAccId = AccountHoldersDirectory.getAccId(userId);
                return recieverAccId;
            }
        }
        return 0;
    }


}
