
import java.util.*;

class BankAcct{
    static final Scanner in=new Scanner(System.in);
    private String acc_no;
    private int balance;
    static float interestRate;
    private float Interest;
    static int count;
    static float rate;
    public void AccDetails(){
        System.out.println("Enter balance : ");
        balance=in.nextInt();
        acc_no=String.format("%04d", count+1);
        System.out.println("Account no. : "+acc_no+" added");
        count++;
    }
    public String RetAccno(){
        return acc_no;
    }
    public void RetIntRate(){
        System.out.println("Interest rate (in %): "+interestRate);
    }
    public static void InitInterestR(float r){
        interestRate=r;
    }
    public static void ChangeInterestR(){
        System.out.println("Enter the new interest rate (in %): ");
        rate=in.nextFloat();
        interestRate=rate;
        System.out.println("Interest rate changed successfully!!");
    }
    public int ShowBalance(){
        return balance;
    }
    public float RetInterest(){
        Interest=balance*interestRate;
        return Interest;
    }
    public String toString(){
        return "Account no. : "+acc_no+" Balance : "+balance+" Interest : "+RetInterest();
    }
}
class Accounts{
    private ArrayList<BankAcct> accts;
    public Accounts(){
        accts=new ArrayList<>();
    }
    public void AddAccount(){
        BankAcct bk=new BankAcct();
        bk.AccDetails();
        accts.add(bk);
    }
    public static void SetInterest(float r1){
        BankAcct.InitInterestR(r1);
    }
    public static void ChangeInt(){
        BankAcct.ChangeInterestR();
    }
    public int SearchAccount(String s){
        for(int i=0;i<accts.size();i++)
            if(accts.get(i).RetAccno().equals(s))
                return i;
        return -1;
    }
    public void ShowB(String s1){
        int b=SearchAccount(s1);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println("Balance : "+accts.get(b).ShowBalance());
    }
    public void ShowInt(String s2){
        int b=SearchAccount(s2);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println("Interest rate : "+accts.get(b).RetInterest());
    }
    public void ShowDetails(String s3){
        int b=SearchAccount(s3);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println("ACCOUNT DETAILS\n----------------\n"+accts.get(b)+"\n");
    }
}
public class AccountMain{
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     Accounts A=new Accounts();
     //BankAcct acc[] = new BankAcct[1000];
     int ch=1;
     while(ch!=0)
     {
         int ch1;
         System.out.println("1. Enter bank details\n2. Set interest rate\n3. Change interest rate\n4. Show balance\n5. Show Interest\n6. Show account info\nEnter your choice");
         ch1=sc.nextInt();
         switch(ch1)
         {
             case 1: A.AddAccount();
                     break;
             case 2: float rate;
                     System.out.println("Enter the interest rate : ");
                     rate = sc.nextFloat();
                     Accounts.SetInterest(rate);
                     break;
             case 3: Accounts.ChangeInt();
                     break;
             case 4: System.out.println("Enter the account no. whose balance should be displayed : ");
                     String b;
                     b=sc.next();
                     A.ShowB(b);
                     break;
             case 5: System.out.println("Enter the account no. whose interest should be displayed : ");
                     String b1;
                     b1=sc.next();
                     A.ShowInt(b1);
                     break;
             case 6: System.out.println("Enter the account no. whose account details should be displayed : ");
                     String b2;
                     b2=sc.next();
                     A.ShowDetails(b2);
                     break;
            default:System.out.println("Enter a valid choice");

         }
         System.out.println("Do you wish to continue ? : (0/1) ");
         ch=sc.nextInt();
         if(ch==1)
            continue;
        else
            System.exit(0);
     }
     sc.close();

    }

}

/*Output
1. Enter bank details
2. Set interest rate
3. Change interest rate
4. Show balance
5. Show Interest
6. Show account info
Enter your choice
1
Enter balance : 
100
Account no. : 0001 added
Do you wish to continue ? : (0/1) 
*/