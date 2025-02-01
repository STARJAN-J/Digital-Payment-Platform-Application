package StarjanProject.Digital_Payment_Platform_App.nowpay;


import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.banking.Account;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;
import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;


public class HomePage {
    private static String loggername;
    private static int userId;
    private int accId = AccountHoldersDirectory.getAccId(userId);
    private User_Transactions transfer = new User_Transactions();
    

    public static void addLoggerName(String loggerName, int id) {
        HomePage.loggername = loggerName;
        HomePage.userId = id;
        System.out.println("\nHello, " + loggerName + "! You've successfully Login Now Pay Services. Enjoy our online banking features. \n");
    }

    public int getUserId() {
        return HomePage.userId;
    }

    // Search Bar
    public void search() {
        System.out.println("You can now search and pay");
        ExceptionHandling.sc.nextLine();
        String anyOne = ExceptionHandling.string("Pay Anyone : ");
        while (true) {
            int contact_FriendAccId = SearchBar.searchBycontacts_Friends(anyOne);
            int upiId_AccId = SearchBar.searchByupiId(anyOne);
            int mobileNo_AccId = SearchBar.searchBymobileNos(anyOne);
            if (contact_FriendAccId != 0) {
                System.out.println("Pay: " +anyOne);
                transfer.enterAmount(userId, contact_FriendAccId, anyOne);
                return;
            }
            else if (upiId_AccId != 0) {
                System.out.println("Pay: " + anyOne);
                transfer.enterAmount(userId, upiId_AccId, anyOne);
                return;
            }
            else if (mobileNo_AccId != 0) {

                for (Account reciever : AccountHoldersDirectory.getAccHolders()) {
                    int id = reciever.getAccId();
                    if (mobileNo_AccId == id) {
                        System.out.println("Pay: " + reciever.getName());
                        break;
                    }
                }    
                transfer.enterAmount(userId, mobileNo_AccId, anyOne);
                return;
            }
            System.out.println("Cannot find any matches for \"" + anyOne + "\". Please try again.");
            anyOne = ExceptionHandling.string("Try Again : ");
        }
    }

    // friends
    public void friends() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i+1 + ". " + NpUser_Data.getHolders().get(i).getName());
        }

        int enter  = ExceptionHandling.Int("Enter number to pay friends : ");
        while (true) {
            if (enter <= 6 && enter > 0) {
                String toName = NpUser_Data.getHolders().get(enter-1).getName();
                System.out.println("Pay: " + toName);
                transfer.enterAmount(userId, SearchBar.searchBycontacts_Friends(toName), toName);   
                return;
            }
            else{
                enter  = ExceptionHandling.Int("Enter digit from 1 to " + 6 + ": ");
            }
        }
    }
    
    // bills
    public void bills() {
        for (int i = 6; i < 18; i++) {
            System.out.println(i-5 + ". " + NpUser_Data.getHolders().get(i).getName());
        }
        int enter  = ExceptionHandling.Int("Enter number to pay bills and merchants : ");
        while (true) {
            if (enter <= 12 && enter > 0) {
                String toName = NpUser_Data.getHolders().get(enter+5).getName();
                System.out.println("Pay: " + toName);
                transfer.enterAmount(userId, SearchBar.searchBycontacts_Friends(toName), toName);   
                return;
            }
            else{
                enter  = ExceptionHandling.Int("Enter the digit from 1 to " + 12 + ": ");
            }
        }
    }

    // check balance
    public void checkBalance() {
        
        for (Account sob : AccountHoldersDirectory.getAccHolders()) {
            if (accId == sob.getAccId()) {
                System.out.println("Your Balance is: " + sob.getSavings() + "\n");
                break;
            }
        }
    }

    // transaction history
    public void transactionHistory() {
        AccountHoldersDirectory.trasactionHistory(accId);
    }
    
    // wallet
    public void addMoneyToWallet() {
        System.out.print("Wallet = ");
        transfer.enterAmount(userId, accId, "Wallet");
    }

    // Wallet Balance
    public void wallet() {
        System.out.println("Wallet Balance Rs. " + AccountHoldersDirectory.getWallets(accId) + "\n");
    }

    
    




}
