package StarjanProject.Digital_Payment_Platform_App.banking;

import java.util.ArrayList;
import java.util.List;

import StarjanProject.Digital_Payment_Platform_App.nowpay.TransactionHistory;

public class Account {
    private String name;
    private double savings;
    private String accNo;
    private String ifsc;
    private int accId;
    private List<TransactionHistory> transactionHistory = new ArrayList<>();
    private double wallet;

    // Constructors
    public Account(String name, double savings, String accNo, String ifsc, int accId, List<TransactionHistory> transactionHistory, double wallet) {
        this.name = name;
        this.savings = savings;
        this.accNo = accNo;
        this.ifsc = ifsc;
        this.accId = accId;
        this.transactionHistory = transactionHistory;
        this.wallet = wallet;
    }

    
    // Getters
    public String getName() {
        return name;
    }

    public double getSavings() {
        return savings;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getIfsc() {
        return ifsc;
    }

    public int getAccId() {
        return accId;
    }

    public List<TransactionHistory> getTransactionHistory() {
        return transactionHistory;
    }

    public double getWallet() {
        return this.wallet;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory.add(transactionHistory);
    }

    public void setWallet(double amount) {
        this.wallet = amount;
    }

    public void topupWallet(double amount) {
        this.wallet = amount;
    }


    // View Transaction History
    public void transactionHistory() {
        for (TransactionHistory transactionHistory : transactionHistory) {
            System.out.println(transactionHistory);
        }
    }
  
    
    

    
}
