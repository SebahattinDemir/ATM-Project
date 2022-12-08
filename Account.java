package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;//hesap no
    private int pinNumber;//sifre
    private double checkingBalance;//vadesiz hesap bakiyesi
    private double savingBalance;//vadeli hesap bakiyesi
    DecimalFormat moneyFormat = new DecimalFormat("$###,###.###");

    Scanner input = new Scanner(System.in);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    //vadesiz hesap para cekme islemi;
    private double calculateCheckingBalanceAfterWithdraw(double amount) {//paraCekmeIslemindenSonraKalanMiktar
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    //vadesiz hesap para yatirma islemi;
    private double calculateCheckingBalanceAfterDeposit(double amount) {//paraYatirmaIslemindenSonraKalanMiktar
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    //vadeli hesap para cekme islemi;
    private double calculateSavingBalanceAfterWithdraw(double amount) {//paraCekmeIslemindenSonraKalanMiktar
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    //vadeli hesap para yatirma islemi;
    private double calculateSavingBalanceAfterDeposit(double amount) {//paraYatirmaIslemindenSonraKalanMiktar
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    public void displayCurrentAmount(double balance) { // Her islem sonundan kalan son bakiyeyi veren method
        System.out.println("Hesabinizda bulunan bakiye: " + moneyFormat.format(balance));
    }

    //Müsteri ile iletisime gecme asamasi "public yaptik diger classlardan ulasmamiz gerekecek"
    //Para Cekme Adimi (Checking) :
    public void getCheckingWithdraw() {
        displayCurrentAmount(checkingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Cekilecek miktar sifir veya eksi rakam olamaz!");
            getCheckingWithdraw();//recursive method ==> methodu tekrardan cagirma
        } else if (amount <= checkingBalance) {
            calculateCheckingBalanceAfterWithdraw(amount);
            displayCurrentAmount(checkingBalance);
        } else
            System.out.println("Yetersiz bakiye!");
    }

    //Para Yatirma Adimi (Checking) :
    public void getCheckingDeposit() {
        displayCurrentAmount(checkingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Yatirilacak miktar sifir veya eksi rakam olamaz!");
            getCheckingDeposit();//recursive method ==> methodu tekrardan cagirma
        } else {
            calculateCheckingBalanceAfterDeposit(amount);
            displayCurrentAmount(checkingBalance);
        }
    }
    //Para Cekme Adimi (Saving) :
    public void getSavingWithdraw() {
        displayCurrentAmount(savingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Cekilecek miktar sifir veya eksi rakam olamaz!");
            getSavingWithdraw();//recursive method ==> methodu tekrardan cagirma
        } else if (amount <= savingBalance) {
            calculateSavingBalanceAfterWithdraw(amount);
            displayCurrentAmount(savingBalance);
        } else
            System.out.println("Yetersiz bakiye!");
    }

    //Para Yatirma Adimi (Saving) :
    public void getSavingDeposit() {
        displayCurrentAmount(savingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Yatirilacak miktar sifir veya eksi rakam olamaz!");
            getSavingDeposit();//recursive method ==> methodu tekrardan cagirma
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            displayCurrentAmount(savingBalance);
        }
    }
}
