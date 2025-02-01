package StarjanProject.Digital_Payment_Platform_App.utils;

import StarjanProject.Digital_Payment_Platform_App.authentication.MapAccount;
import StarjanProject.Digital_Payment_Platform_App.authentication.NpUser_Data;
import StarjanProject.Digital_Payment_Platform_App.authentication.User;
import StarjanProject.Digital_Payment_Platform_App.banking.AccountHoldersDirectory;
import StarjanProject.Digital_Payment_Platform_App.banking.Accounts;

public class DataFetcher {

    public  void addData() {
        importUser();
        Accounts.accountLoad();
        mapUserId_AccId();
    }

    
    public void importUser() {
        NpUser_Data.addHoldersmanual(new User("Steins", "albertsteins456@gmail.com", "8888888888", "Albertsteins@88"));
        NpUser_Data.addHoldersmanual(new User("Rex", "rexalan123@gmail.com", "9999999999", "Rexalan@999"));        
        NpUser_Data.addHoldersmanual(new User("Stalin","uruttistalin789@gmail.com", "7777777777", "Urutti@7777"));
        NpUser_Data.addHoldersmanual(new User("Vetrimaaran", "vetrimaaran1011@gmail.com", "9999988888", "Vetrimaaran@98"));
        NpUser_Data.addHoldersmanual(new User("Sundar C", "sundarc1112@gmail.com", "9999977777", "Sundarc@997"));
        NpUser_Data.addHoldersmanual(new User("Ks Ravikumar", "ksravikumar1213@gmail.com", "8888877777", "Ksravikumar@87"));
        
        
        NpUser_Data.addHoldersmanual(new User("Tamil Nadu Electricity", "tamilnaduElectricity123@gmail.com", "9181716151", "TamilElectr@91"));
        NpUser_Data.addHoldersmanual(new User("Mobile Recharge", "recharge234@gmail.com", "8171615141", "Recharge@81"));
        NpUser_Data.addHoldersmanual(new User("DTH / Cable TV", "tvrecharge345@gmail.com", "7161514131","Tvrecharge@71"));
        NpUser_Data.addHoldersmanual(new User("FastTag recharge", "fastag456@gmail.com", "6151413121", "fastagre@61"));
        NpUser_Data.addHoldersmanual(new User("Gas Cylinder booking", "gasbooking567@gmail.com", "9282726252", "Cylinder@92"));
        NpUser_Data.addHoldersmanual(new User("Electricity", "electricity789@gmail.com", "8272625242", "Electricity@82"));
        NpUser_Data.addHoldersmanual(new User("Broadband / Landline", "broadband678@gmail.com", "7262524232", "Broadband@7"));
        NpUser_Data.addHoldersmanual(new User("Life insurance Corporation", "lifeinsurance987@gmailcom", "8979695949", "Lifeinsurance@89"));
        NpUser_Data.addHoldersmanual(new User("Credit Cards", "creditcard789@gmail.com", "9383736353", "Credtcard@93"));
        NpUser_Data.addHoldersmanual(new User("Google Play", "googleplay988@gmail.com", "8373635343", "googleplay@83"));
        NpUser_Data.addHoldersmanual(new User("Education", "education888@gmail.com", "7363534363", "Education@73"));
        NpUser_Data.addHoldersmanual(new User("Loan", "loan8989@gmail.com", "9363835373", "Loan@123456"));


        NpUser_Data.addHoldersmanual(new User("Donald Trump", "donaldtrum100@gmail.com", "9486451768", "Donaldtrump@100"));
        NpUser_Data.addHoldersmanual(new User("Prasanth Neel", "prasanthneel01@gmail.com", "8546321522", "Prasanthneel@101"));
        NpUser_Data.addHoldersmanual(new User("Narendra Modi", "narendramodil02@gmail.com", "6324525255", "Narendramodi@102"));
        NpUser_Data.addHoldersmanual(new User("SS Rajamouli", "ssrajamoulil03@gmail.com", "9461224224", "SSRajamouli@103"));
        NpUser_Data.addHoldersmanual(new User("Captain Prabakaran", "captainprabakaranl04@gmail.com", "9315852245", "Captainprabakaran@104"));
        NpUser_Data.addHoldersmanual(new User("Udayanithi", "udayanithi105@gmail.com", "7532222635", "Udayanithi@105"));
        NpUser_Data.addHoldersmanual(new User("Inbanithi", "inbanithil06@gmail.com", "8651454544", "Inbanithi@106"));
        NpUser_Data.addHoldersmanual(new User("Thunbanithi", "thunbanithil07@gmail.com", "6614654165", "Thunbanithi@107"));
        NpUser_Data.addHoldersmanual(new User("Thuyaranithi", "thuyaranithil08@gmail.com", "6514847514", "Thuyaranithi108"));
    
    
    }

    public  void mapUserId_AccId() {
        
        int j = 0;
        
        for (int i = 0; i < NpUser_Data.getHolders().size(); i++) {
            int userId = NpUser_Data.getHolders().get(i).getUserId();
            int accId = AccountHoldersDirectory.getAccHolders().get(j).getAccId();
            String accNo = AccountHoldersDirectory.getAccHolders().get(j).getAccNo();
            String ifsc = AccountHoldersDirectory.getAccHolders().get(j).getIfsc();
            AccountHoldersDirectory.mapWithSob_UsingAccIdUserID(userId, accId);
            NpUser_Data.mapBankAccount_credentials(userId, new MapAccount(userId, accId, accNo, ifsc));
            j++;
        }
    }


}