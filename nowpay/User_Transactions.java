package StarjanProject.Digital_Payment_Platform_App.nowpay;

import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.banking.Account;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;
import StarjanProject.Digital_Payment_Platform_App.exceptionHandling.ExceptionHandling;

public class User_Transactions {
    private double amount;
    private int userId;
    private int userAccId;

    // Getters
    public double getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }
    
    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    // Transfer Amount
    public void enterAmount(int userid, int recieverAccID, String toName) {
        this.userAccId = AccountHoldersDirectory.getAccId(userid);
        double amnt = ExceptionHandling.Double("Rs: ");
        if (canPayUsingWallet(amnt) && !toName.equals("Wallet")) {
            int enter = ExceptionHandling.Int("Your wallet has sufficient funds, enter 1 to enjoy PIN-free payment: ");
            if (enter == 1 && userid != recieverAccID) {
                setAmount(amnt);
                setUserId(userid);
                amountTransferFromWallet(recieverAccID);
                storeTransactions(userAccId, toName, "-", this.amount);
                storeTransactions(recieverAccID, AccountHoldersDirectory.getName(this.userAccId), "+", this.amount);
                return;
            }
        }
        while (true) {
            if (amnt <= AccountHoldersDirectory.getSaving(userAccId) && amnt > 0) {
                break;
            }
            System.out.println("Insufficient balance or invalid amount");
            amnt = ExceptionHandling.Double("ReEnter Rs: ");
        }
        int upin = ExceptionHandling.Int("Enter 6- digit U-Pin : ");
        while (true) {
            if (NpUser_Data.getUserBankAccount_credetials().get(userid).getUpin() == upin) {
                setAmount(amnt);
                setUserId(userid);
                amountTransfer(recieverAccID);
                if(toName.equals("Wallet")) {
                    AccountHoldersDirectory.topupWallet(userAccId, amnt);
                    storeTransactions(userAccId, toName, "-", this.amount);
                    return;
                }
                storeTransactions(userAccId, toName, "-", this.amount);
                storeTransactions(recieverAccID, AccountHoldersDirectory.getName(this.userAccId), "+", this.amount);
                return;
            }
            System.out.println("Incorrect U-Pin entered");
            upin = ExceptionHandling.Int("ReEnter 6- digit U-Pin : ");
        }        
    }

    // Transfer Amount
    public void amountTransfer(int recieverAccID) {
        AccountHoldersDirectory.setSavings(userAccId, recieverAccID, this.amount);
    }

    // Transfer Amount thorough wallet
    public void amountTransferFromWallet(int recieverAccID) {
        AccountHoldersDirectory.setWallet(userAccId, recieverAccID, this.amount);
    }
    
    // Trasaction History
    public void storeTransactions(int accId, String toName, String sign, double amount) {
        for (Account sob : AccountHoldersDirectory.getAccHolders()) {
            if (sob.getAccId() == accId) {
                sob.setTransactionHistory(new TransactionHistory(ExceptionHandling.todayDate(), toName, sign, amount));
                return;
            }
        }
    }

    // is wallet has enough money
    public boolean canPayUsingWallet(double amnt) {
        if (amnt <= AccountHoldersDirectory.getWallets(userAccId) && amnt > 0) {
            return true;
        }
        return false;
    }
    




}
