package StarjanProject.Digital_Payment_Platform_App.nowpay;

import StarjanProject.Digital_Payment_Platform_App.App;
import StarjanProject.Digital_Payment_Platform_App.authentication.Login;
import StarjanProject.Digital_Payment_Platform_App.authentication.MapAccount;
import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.authentication.User;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;
import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;
import StarjanProject.Digital_Payment_Platform_App.utils.DataFetcher;

public class NowPay {
    

    public void run() {
        
        DataFetcher fetch = new DataFetcher();
        fetch.addData();
        
        /*NpUser_Data.showHolders();
        AccountHoldersDirectory.viewAccHolders();
        System.out.println(AccountHoldersDirectory.getMapWithSob_UsingAccIdUserID());
        NpUser_Data.showAccountCredentials();
        // NpUser_Data.setTempHolder(new User("Starjan", "davidstarjan007@gmail.com", "9095993322", "Starjan@2596"));*/

        boolean flag = true;
        while (flag) {
            int enter = ExceptionHandling.Int("1. Don't have an account -> SignUp\n2. Already have an account -> Login\n3. Exit\nEnter Number: ");
            System.out.println();
            switch (enter) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    

    // SignUp
    public  void signUp() {
        User sign = new User();
        sign.enterName();
        sign.enterPhoneNumber();
        sign.enterMailId();
        sign.enterPassword();

        // System.out.print("If you want to clear console enter 1: ");
        // int enter = functions.sc.nextInt();
        // if (enter == 1) {
        //     functions.clearConsole();
        // }

        System.out.println("\nSignUp successfully\n");
        System.out.println("Your UserId is " + sign.getUserId() + "\n");
    }

    // Login
    public  void login() {
        Login login = new Login();
        login.login();
        if (MapAccount.getUserId() > 0) {
            homePage();
        }
    }

    // Home Page
    public   void homePage() {
        HomePage page = new HomePage();
        // System.out.println("Home page USer Id: " + page.getUserId());
        boolean flag = true;
        while (flag) {
            int enter = ExceptionHandling.Int("1. Search\n2. Friends\n3. Bills\n4. Check Balance\n5. Add money to Wallet\n6. Wallet\n7. Transaction History\n8. Exit\nEnter Number: ");
            System.out.println();
            switch (enter) {
                case 1:
                    page.search();
                    break;
                case 2:
                    page.friends();
                    break;
                case 3:
                    page.bills();
                    break;
                case 4: 
                    page.checkBalance();
                    break;
                case 5:
                    page.addMoneyToWallet();
                    break;
                case 6:
                    page.wallet();
                    break;
                case 7: 
                    page.transactionHistory();
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        
    }









































}
