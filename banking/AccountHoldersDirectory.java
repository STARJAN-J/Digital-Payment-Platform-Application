package StarjanProject.Digital_Payment_Platform_App.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AccountHoldersDirectory {
    private static List<Account> accHolders = new ArrayList<>();
    private static Map<Integer, Integer> mapWithSob_UsingAccIdUserID = new HashMap<>();

    // Getters
    public static List<Account> getAccHolders() {
        return accHolders;
    }

    public static Map<Integer, Integer> getMapWithSob_UsingAccIdUserID() {
        return mapWithSob_UsingAccIdUserID;
    }

    
    // Add Account Holder
    public static void addAccHolder(Account account) {
        AccountHoldersDirectory.accHolders.add(account);
    }

    // Map UserId Account Id
    public static void mapWithSob_UsingAccIdUserID(int userId, int accId) {
        AccountHoldersDirectory.mapWithSob_UsingAccIdUserID.put(userId, accId);
    }
    
    // View Account Holder
    public static void viewAccHolders() {        
        for (Account sob : accHolders) {
            System.out.print("[");
            System.out.print("Name: Mr." + sob.getName() + " | Account Id:" + sob.getAccId() + " | Account No: " + sob.getAccNo() + " | IFSC Code: " + sob.getIfsc() + " | Saving: " + sob.getSavings());
            System.out.print("]");
            System.out.println();
        }
        
    }
    
    // get Account Id
    public static int getAccId(int userId) {
        while (true) {
            for (Map.Entry<Integer, Integer> ids: mapWithSob_UsingAccIdUserID.entrySet()) {
                if (ids.getKey() == userId) {
                    return ids.getValue();
                }
            }
        }
    }

    // getName
    public static String getName(int accId) {
        while (true) {
            for (Account account : accHolders) {
                if (account.getAccId() == accId) {
                    return account.getName();
                }
            }
        }
    }

    // SetSaving
    public static void setSavings(int userAccId, int recieverAccId, double amount) {
        for (Account sob : accHolders) {
            if (sob.getAccId() == userAccId) {
                sob.setSavings(Math.abs(sob.getSavings()-amount));
                System.out.println("Amount debited \n");
                break;
            }
        }

        if (userAccId != recieverAccId) {
            for (Account sob : accHolders) {
                if (sob.getAccId() == recieverAccId) {
                    sob.setSavings(Math.abs(sob.getSavings()+amount));
                    // System.out.println("Amount debited \n");
                    break;
                }
            }
        }
        return;
    }

    // SetWallet
    public static void setWallet(int userAccId, int recieverAccId, double amount) {
        for (Account sob : accHolders) {
            if (sob.getAccId() == userAccId) {
                sob.setWallet(Math.abs(sob.getWallet() - amount));
                System.out.println("Amount debited, Wallet Balance: " + sob.getWallet() + "\n");
                break;
            }
        }

        for (Account sob : accHolders) {
            if (sob.getAccId() == recieverAccId) {
                sob.setSavings(Math.abs(sob.getSavings()+amount));
                // System.out.println("Amount debited \n");
                break;
            }
        }
        return;
    }

    // TopUp wallet
    public static void topupWallet(int accId, double amount) {
        for (Account sob : accHolders) {
            if (sob.getAccId() == accId) {
                sob.topupWallet((Math.abs(sob.getWallet() + amount)));
                System.out.println("Amount added to wallet, Wallet Balance: " + sob.getWallet() + "\n");
                break;
            }
        }
    }

    // GetSaving
    public static double getSaving(int accId) {
        while (true) {
            for (Account sob : accHolders) {
                if (sob.getAccId() == accId) {
                    return sob.getSavings();
                }
            }
        }
    }

    // Get Wallet
    public static double getWallets(int accId) {
        while (true) {
            for (Account sob : accHolders) {
                if (sob.getAccId() == accId) {
                    return sob.getWallet();
                }
            }
        }
    }

    // Transaction History
    public static void trasactionHistory(int accId) {
        for (Account sob : accHolders) {
            if (sob.getAccId() == accId) {
                sob.transactionHistory();
            }
        }
    }



    
}
