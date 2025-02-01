package StarjanProject.Digital_Payment_Platform_App.authentication;

import StarjanProject.Digital_Payment_Platform_App.banking.Account;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;
import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;
import StarjanProject.Digital_Payment_Platform_App.utils.Id_PinGenerator;

public class MapAccount {    
    private String accountNum;
    private String ifscCode;
    private int Upin;
    private String upiId;
    private static int userId; 
    private int accId;   



    public MapAccount(int userId, int accId, String accountNum, String ifscCode) {
        MapAccount.userId = userId;
        this.accId = accId;
        this.accountNum = accountNum;
        this.ifscCode = ifscCode;
        this.upiId = createUpiId();
        Id_PinGenerator uPin = new Id_PinGenerator();
        uPin.setUpin();
        int pin = uPin.getUpin();
        this.Upin = pin;
    }

    public MapAccount(int userId) {
        MapAccount.userId = userId;
        isAccountInBank();
        isAccountExist();
        this.Upin = createUpin();
        this.upiId = createUpiId();
        System.out.println("UPI Id : " + this.upiId);
    }

    public String enterAccountNum() {
        String accNo = ExceptionHandling.string("Enter Bank Account Number : ");
        while (true) {
            if (accNo.length() == 11) {
                return accNo;
            }
            else  {
                System.out.println("Your Account number digit should be 11 digits");
                accNo = ExceptionHandling.string("ReEnter Bank Account Number : ");
            }
        }
        
    }

    public String enterifscCode() {
        String ifsc = ExceptionHandling.string("Enter IFSC Code : ");
        while (true) {
            if (ifsc.length() == 11 && ifsc.matches("^[A-Z]+\\d+$")) {
                return ifsc;
            }
            else  {
                System.out.println("You entered IFSC Code format is not correct Eg : ABCD0012345");
                ifsc = ExceptionHandling.string("ReEnter IFSC Code : ");
            }
        }
    }

    public int createUpin() {
        int pin = ExceptionHandling.Int("Create 6-digit Upin : ");
        while (true) {
            if (pin > 99999 && pin < 1000000) {
                return pin;
            }
            else{
                System.out.println("Upin must be in 6 digit");
                pin = ExceptionHandling.Int("ReEnter 6-digit Upin : ");
            }
        }

    }

    public String createUpiId() {
        return Id_PinGenerator.generateUpiId(userId);
    }

    // Getters
    public String getAccountNum() {
        return accountNum;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public int getUpin() {
        return Upin;
    }

    public static int getUserId() {
        return userId;
    }

    public  int getAccId() {
        return this.accId;
    }

    public String getUpiId() {
        return upiId;
    }

    // This method for get the input from users
    public void isAccountInBank() {        
        String accNo = enterAccountNum();
        String ifsc = enterifscCode();
        while (true) {            
            for (Account sob : AccountHoldersDirectory.getAccHolders()) {
                if (sob.getAccNo().equalsIgnoreCase(accNo) && sob.getIfsc().equalsIgnoreCase(ifsc)) {
                    this.accountNum = accNo;
                    this.ifscCode = ifsc;
                    AccountHoldersDirectory.mapWithSob_UsingAccIdUserID(userId, sob.getAccId());
                    this.accId = AccountHoldersDirectory.getAccId(userId);
                    return;
                }
            }
            System.out.println("Account Number or Ifsc Code is wrong, Please ReEnter.");
            accNo = enterAccountNum();
            ifsc = enterifscCode();
        }
    }
    
    // If Existing account created
    public void isAccountExist() {
        if (NpUser_Data.isAccountMapped(accountNum, ifscCode)) {
            System.out.println("This account is already linked. Please add another bank account to continue.");
            isAccountInBank();
            
        }
    }

}
