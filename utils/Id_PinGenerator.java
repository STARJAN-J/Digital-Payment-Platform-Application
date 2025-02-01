package StarjanProject.Digital_Payment_Platform_App.utils;


import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.authentication.User;

public class Id_PinGenerator {
    private static int userId_Counter = 121;
    private static int accId_Counter = 251901;
    private static int upinCounter = 369560;
    private int userId;
    private int accId;
    private int Upin;

    // Getters
    public int getUserId() {
        return userId;
    }

    public int getAccId() {
        return accId;
    }

    public int getUpin() {
        return Upin;
    }

    // Setters
    public void setUserId() {
        this.userId = userId_Counter++;
    }    

    public void setAccId() {
        this.accId = accId_Counter++;
    }

    public void setUpin() {
        this.Upin = upinCounter++;
    }


    public static String generateUpiId(int userId) {
        while (true) {
            for (User user : NpUser_Data.getHolders()) {
                int id = user.getUserId();
                String mailId = user.getMailId().split("@")[0] + id + "-1@";
                if (id == userId) {
                    return mailId + "OkSob";
                }
            }
        }
    }

    

    

}
