package StarjanProject.Digital_Payment_Platform_App.authentication;


import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;
import StarjanProject.Digital_Payment_Platform_App.nowpay.HomePage;

public class Login {
    private int userId;
    private String password;
    // private boolean isNextLogger = false;

    public Login() {

    }

    
    public void setUserId() {
        this.userId = ExceptionHandling.Int("Enter the provided UserId: ");
    }

    public void setPassword() {
        ExceptionHandling.sc.nextLine();
        this.password = ExceptionHandling.string("Enter Password : ");
    }
    
    // Login
    public void login() {
        setUserId();
        setPassword();

        int retryCount = 0;
        final int maxRetries = 3;

        while (retryCount < maxRetries) {
            for (User sign : NpUser_Data.getHolders()) {
                if (sign.getUserId() == userId && sign.getPassword().equals(password)) {     

                    HomePage.addLoggerName(sign.getName(), userId);

                    return;
                }            
            }
            retryCount++;
            
            if (retryCount < maxRetries) {
                System.out.println("Invalid login credentials. Please try again (" + retryCount + "/" + maxRetries + ").");
                setUserId();
                setPassword();
            }
            else{
                System.out.println("Too many failed attempt, Exiting.....");
                return;
            }

        }
    }
    

    
}
