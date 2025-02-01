package StarjanProject.Digital_Payment_Platform_App.authentication;

import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;
import StarjanProject.Digital_Payment_Platform_App.utils.Id_PinGenerator;



public class User {
    
    private String name;
    private String mailId;
    private String phoneNumber;
    private String password;
    private int userId;

    public User() {
        // Automatically add this object to npHolder
        // NpHolders.addHolders(this);
        Id_PinGenerator userId = new Id_PinGenerator();
        userId.setUserId();
        int id = userId.getUserId();
        this.userId = id;
    }

    public User(String name, String mailId, String phoneNumber, String password) {
        this.name = name;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        Id_PinGenerator userId = new Id_PinGenerator();
        userId.setUserId();
        int id = userId.getUserId();
        this.userId = id;
        // Automatically add this object to npHolder
        // NpHolders.addHolders(this);
    }

    public void enterName() {
        ExceptionHandling.sc.nextLine();
        String name = ExceptionHandling.string("Enter your name : ");
        this.name = name;
    }

    public void enterMailId() {
        String mailId = ExceptionHandling.string("Enter your MailId : ");
        while (true) {
            if (mailId.matches("^[a-zA-Z0-9._%+-]*\\d+[a-zA-Z0-9._%+-]*@gmail\\.com$")) {
                this.mailId = mailId;
                return;
            }
            else{
                System.out.println("MailId should contain digits and @gmail.com");
                mailId = ExceptionHandling.string("ReEnter your MailId : ");
            }
        }
    }

    public void enterPhoneNumber() {
        
        String phoneNumber = ExceptionHandling.string("Enter your Mobile Number : ");
        
        while (true) {
            if (phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                this.phoneNumber = phoneNumber;
                return;
            }
            else{
                System.out.println("Your phone number should contain 10 numbers & not a alphabets");
                phoneNumber = ExceptionHandling.string("ReEnter new mobile number : ");
            }
        }
    }

    public void enterPassword() {
        String password = ExceptionHandling.string("Create Password, \nExample : Abcdefg@123 \nEnter new password : ");
        while (true) {
            if (password.length() >= 11 
            && password.matches(".*[A-Z].*") // Contains at least one uppercase letter
            && password.matches(".*[a-z].*") // Contains at least one lowercase letter
            && password.matches(".*\\d.*")  // Contains at least one digit
            && password.matches(".*[@#$%^&+=].*")) {
                this.password = password;
                break;
            }
            else{
                System.out.println("Your password length must be above 11 characters & \"Contains at least one uppercase letter\" & \"Contains at least one lowercase letter\" & \"Contains at least one digit\" & \"Contains at least one Special Character\" " );
                password = ExceptionHandling.string("ReEnter new password : ");
            }
        }
        // Automatically add this object to npHolder
        NpUser_Data.addHolders(this);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMailId() {
        return mailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
