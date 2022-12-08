package atmproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account{

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("$###,###.###");
    HashMap<Integer, Integer> data = new HashMap<>();
    boolean flag = true;

    public void login(){
        System.out.println("Bankamıza Hoş Geldiniz...");
        do {
            data.put(12345, 1234);
            data.put(23456, 2345);
            data.put(34567, 3456);
            data.put(45678, 4567);
            try{
                System.out.println("Hesap numaranizi giriniz:");
                setAccountNumber(input.nextInt());
                System.out.println("Pin numaranizi giriniz:");
                setPinNumber(input.nextInt());
            }catch (Exception e){
                System.out.println("Yanlis karakter girdiniz! Lutfen sadece rakam giriniz veya çıkış yapmak isterseniz Q ya basip cikabilirsiniz");
                input.nextLine();
                String exit = input.next();
                if(exit.equalsIgnoreCase("q")){
                    flag = false;
                }
            }
            int count = 0;
            for(Map.Entry<Integer, Integer> w:data.entrySet() ){
                if(w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber()) ){
                    getAccountTypes();//hesap islemlerine yönlendirir
                }else{
                    count++;
                }
            }
            if(count == data.size()){
                System.out.println("Yanlis hesap numarasi veya pin numarasi girdiniz");
            }
        }while (flag);
    }

    //Checking(Vadesiz) Hesap islemleri
    public void checkingOperations(){
        do {
            displayMessage();
            int option = input.nextInt();
            if (option==4){
                break;
            }
            switch (option){
                case 1:
                    System.out.println("Checking hesabinizda bulunan bakiyeniz : "+ moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Yanlıs giris yaptiniz. Lütfen 1-2-3 veya 4 seceneklerinden birisini seciniz.");
            }
        }while(true);
        getAccountTypes();
    }
    //Saving(Vadeli) Hesap islemleri
    public void savingOperations(){

        do {
            displayMessage();
            int option = input.nextInt();
            if (option==4){
                break;
            }
            switch (option){
                case 1:
                    System.out.println("Saving hesabinizda bulunan bakiyeniz : "+ moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWithdraw();
                    break;
                case 3:
                    getSavingDeposit();
                    break;
                default:
                    System.out.println("Yanlıs giris yaptiniz. Lütfen 1-2-3 veya 4 seceneklerinden birisini seciniz.");
            }
        }while(true);
        getAccountTypes();
    }

    //Kullanıcı için seçenekleri görüntüleme methodu
    public void displayMessage(){
        System.out.println("Options seciniz:\n"+"1. View Balance\n"+"2. Withdraw\n"
                +"3. Deposit\n"+"4. Exit");
    }

    //Kullaniciya Islem yapacagi hesabi sectirme methodu
    public void getAccountTypes(){
        System.out.println("Işlem yapmak istediginiz hesabi seciniz:\n"+"1. Checking account\n"+"2. Saving account\n"
                +"3. Quit");
        int option = input.nextInt();
        switch (option){
            case 1:
                System.out.println("Checking/vadesiz hesabinizdasiniz");
                checkingOperations();
            case 2:
                System.out.println("Saving/vadeli hesabinizdasiniz");
                savingOperations();
            case 3:
                System.out.println("Bankamızı tercih ettiginiz icin tesekkur ederiz!");
                flag=false;
                break;
            default:
                System.out.println("Yanlis giriş yaptınız! Lutfen 1,2 veya 3'u kullaniniz");
        }
    }


}
