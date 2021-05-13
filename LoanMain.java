import java.util.*;
class CreditExcedeedException extends Exception{
    CreditExcedeedException(){
        super("Credit limit reached cannot avail loan!!");
    }
}
class Loan {
Scanner in = new Scanner(System.in).useDelimiter("\n");
 private String customer_id;
 private String name;
 private double current_loan=0;
 private String ph_no;
 private double asking_amount;
 private char priviledge;
 private double credit;
 static final double creditforall=100000.0;
 static int count=0;
 public void SetDetails()
 {
    customer_id=String.format("%04d", count+1);
    System.out.println("Enter name : ");
    name=in.next();
    System.out.println("Enter phone no. : ");
    ph_no=in.next();
    System.out.println("Priviledged or not? : (p/n) ");
    priviledge=in.next().charAt(0);
    if(priviledge=='p')
        credit=creditforall*2;
     else if(priviledge=='n')
        credit=creditforall;
     else 
        System.out.println("Enter a valid priviledge");
    System.out.println("Loan account with customer Id "+customer_id+" added successfully!!");
    count++;
 }
 public String RetCusid()
 {
     return customer_id;
 }
 public void ChangeDetails(String n,String p)
 {
     name=n;
     ph_no=p;
     System.out.println("Details changed succesfully!!");
 }
 public double RetCredit()
 {
     return credit;
 }
 public double CurrentLoanamt(){
    return current_loan;
}
 public void TakeLoan(double d)throws CreditExcedeedException
 {
    if(d<RetLoanSeek())
    {
        asking_amount=d;
        current_loan+=asking_amount;
        System.out.println("Loan sanctioned successfully!!");
    }
    else
        throw new CreditExcedeedException();
 }
 
 public double RetLoanSeek()throws CreditExcedeedException{
     double amt=credit-current_loan;
     if(amt>0)
        return amt;
    else
        throw new CreditExcedeedException();

 }
 public String toString(){
     return "Customer id : "+customer_id+" Name : "+name+" Phone no. : "+ph_no+" Current loan amount : "+current_loan;
 }
}

class LoanAccounts{
    Scanner s=new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Loan> la;
    public LoanAccounts()
    {
        la=new ArrayList<>();
    }
    public void AddAccount(){
        Loan l=new Loan();
        l.SetDetails();
        la.add(l);
    }
    public int SearchLoanAccount(String s)
    {
        for(int i=0;i<la.size();i++)
            if(la.get(i).RetCusid().equals(s))
                return i;
        return -1;
    }
    public void ChangeDet(String a){
        int b=SearchLoanAccount(a);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            {
                System.out.print("Enter new name : ");
                String na=s.next();
                System.out.println("Enter new new phone no. : ");
                String ph=s.next();
                la.get(b).ChangeDetails(na, ph);
            }
    }
    public void ShowCred(String a1){
        int b=SearchLoanAccount(a1);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println("Credit : "+la.get(b).RetCredit());
    }
    public void SeekLoan(String a2){
        int b=SearchLoanAccount(a2);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else{
            try{
                System.out.println("Enter the loan amount : ");
                double loan=s.nextDouble();
                la.get(b).TakeLoan(loan);
            }
            catch(Exception e){
                System.err.println("Error : "+e.getMessage());
            }
        }
    }
    public void ShowCurrentLoan(String a3){
        int b=SearchLoanAccount(a3);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println("Current loan amount : "+la.get(b).CurrentLoanamt());
    }
    public void LoanAvail(String a4){
        int b=SearchLoanAccount(a4);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else{
            try{
            System.out.println("Loan seekable : "+la.get(b).RetLoanSeek());
            }
            catch(Exception e){
                System.err.println("Error : "+e.getMessage());
            }
        }
    }
    public void ShowDet(String a5){
        int b=SearchLoanAccount(a5);
        if(b==-1)
            System.out.println("Account no. does not exists!!");
        else
            System.out.println(la.get(b)); 
    }
}

public class LoanMain{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        LoanAccounts La=new LoanAccounts();
     int ch=1;
     while(ch!=0)
     {
         int ch1;
         System.out.println("1. Add Account\n2. Change details\n3. Show Credit\n4. Seek Loan\n5. Show current loan amount\n6. Show amount of loan that can be availed\n7. Show details of an account\nEnter your choice");
         ch1=sc.nextInt();
         switch(ch1)
         {
             case 1: La.AddAccount();
                     break;
             case 2: System.out.println("Enter the customer id whose details has to be changed : ");
                     String b;
                     b=sc.next();
                     La.ChangeDet(b);
                     break;
             case 3: System.out.println("Enter the customer id : ");
                     String b1;
                     b1=sc.next();
                     La.ShowCred(b1);
                    break;
             case 4: System.out.println("Enter the customer id : ");
                     String b2;
                     b2=sc.next();
                     La.SeekLoan(b2);
                     break;
             case 5: System.out.println("Enter the customer id whose current loan amount should be displayed : ");
                     String b3;
                     b3=sc.next();
                     La.ShowCurrentLoan(b3);
                    break;
            case 6: System.out.println("Amount of loan that can be availed for a particular customer id : ");
                    String b4;
                    b4=sc.next();
                    La.LoanAvail(b4);
                    break;
            case 7: System.out.println("Enter the customer id : ");
                    String b5;
                    b5=sc.next();
                    La.ShowDet(b5);
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
1. Add Account
2. Change details
3. Show Credit
4. Seek Loan
5. Show current loan amount
6. Show amount of loan that can be availed
7. Show details of an account
Enter your choice
1
Enter name : 
abcd 
Enter phone no. : 
927288110
Priviledged or not? : (p/n) 
p
Loan account with customer Id 0001 added successfully!!
Do you wish to continue ? : (0/1) 
1
1. Add Account
2. Change details
3. Show Credit
4. Seek Loan
5. Show current loan amount
6. Show amount of loan that can be availed
7. Show details of an account
Enter your choice
3
Enter the customer id : 
0001
Credit : 200000.0
Do you wish to continue ? : (0/1) 
0*/