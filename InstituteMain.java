import java.util.*;

class person{
    Scanner sc=new Scanner(System.in).useDelimiter("\n");
    private String name;
    private String ph_no;
    private String mail_id;
    private Address address;
    
    class Address{
        private int premise_no;
        private String street;
        private String city;
        private long pin;
        private String state;
        
        public void SetAdrress(){
            System.out.println("Enter the premise no. : ");
            premise_no=sc.nextInt();
            System.out.println("Enter street : ");
            street=sc.next();
            System.out.println("Enter city : ");
            city=sc.next();
            System.out.println("Enter pin : ");
            pin=sc.nextInt();
            System.out.println("Enter State : ");
            state=sc.next();
        }
        public void ChangePremise(int p){
            premise_no=p;
            System.out.print("Premise no. changed successfully!!");
        }
        public void ChangeStreet(String s)
        {
            street=s;
            System.out.println("Street changed successfully!!\n");
        }
        public void ChangeCity(String c)
        {
            city=c;
            System.out.println("City changed successfully!!\n");
        }
        public void ChangePin(long i)
        {
            pin=i;
            System.out.println("Pin changed successsfully!!\n");
        }
        public void ChangeState(String st)
        {
            state=st;
            System.out.println("State changed sucessfully!!\n");
        }
        public String toString(){
            return "Address\nPremise no. : "+premise_no+" Street : "+street+" City : "+city+" Pin : "+pin+" State : "+state;
        }
    }
    public void SetData(){
        System.out.println("Enter your name : ");
        name=sc.next();
        System.out.println("Enter phone number : ");
        ph_no=sc.next();
        System.out.println("Enter email id : ");
        mail_id=sc.next();
        address=new Address();
        address.SetAdrress();
    }
    public void ChangeAddress(){
        System.out.print("1. Change premise n0.?\n2. Change street?\n3. Change city?\n4. Change pin?\n5. Change state?\nEnter your choice?");
        int i=sc.nextInt();
        switch(i)
        {
            case 1: System.out.println("Enter new premise no. : ");
                    int i1=sc.nextInt();
                    address.ChangePremise(i1);
                    break;
            case 2: System.out.println("Enter new street : ");
                    String s1=sc.next();
                    address.ChangeStreet(s1);
                    break;
            case 3: System.out.println("Enter new city : ");
                    String s2=sc.next();
                    address.ChangeCity(s2);
                    break;
            case 4: System.out.println("Enter new pin : ");
                    long l=sc.nextInt();
                    address.ChangePin(l);
                    break;
            case 5: System.out.println("Enter new state : ");
                    String s3=sc.next();
                    address.ChangeState(s3);
                    break;
            default: System.out.println("Enter a valid choice");

        }
    }
    public void ShowData(){
        System.out.println("Name : "+name+" Phone no.  "+ph_no+" Email id : "+mail_id+"\n"+address);
    }
    //abstract protected String PersonId(int i);
}
class Student extends person{
    private String roll_no;
    private String course;
    static int count;
    @Override
    public void SetData(){
        super.SetData();
        System.out.println("Enter course : ");
        course=sc.next();
        //String r=course.toUpperCase();
        roll_no=String.format("%3s_%03d", course.toUpperCase(), count+1);
        System.out.println("Student with roll no. : "+roll_no+" added successfully!!\n");
        count++;
    }
    public String RetRoll(){
        return roll_no;
    }
    public String RetCourse(){
        return course;
    }
    public void ChangeAddress(){
        super.ChangeAddress();
    }
    @Override
    public void ShowData(){
        super.ShowData();
        System.out.println("Course : "+course+" Roll no. : "+roll_no);
    }

}
class Faculty extends person{
    private String emp_id;
    private String dept;
    private String specialisation;
    static int fcount=0;
    @Override
    public void SetData(){
        super.SetData();
        System.out.println("Enter Department of the faculty member : ");
        dept=sc.next();
        System.out.println("Enter specialisation : ");
        specialisation=sc.next();
        emp_id=String.format("%3s_%03d", specialisation.toUpperCase(), fcount+1);
        System.out.println("Faculty member with employee id : "+emp_id+" added successfully!!\n");
        fcount++;
    }
    public String RetEmpId(){
        return emp_id;
    }
    public void ChangeAddress(){
        super.ChangeAddress();
    }
    @Override
    public void ShowData(){
        super.ShowData();
        System.out.println("Faculty dept. : "+dept+" Specialisation : "+specialisation+" Employee Id : "+emp_id+"\n");
    }

}
class Institute {
    private ArrayList<Student> std;
    private ArrayList<Faculty> fclt;
    
    public Institute(){
        std=new ArrayList<>();
        fclt=new ArrayList<>();
    }
    public void AddStudents()
    {
        Student s=new Student();
        s.SetData();
        std.add(s);
        //System.out.println("Student with roll no. "+std.get(Student.count).RetRoll()+"added successfully!!\n");
    }
    public void AddFaculty(){
        Faculty f=new Faculty();
        f.SetData();
        fclt.add(f);
        //System.out.println("Faculty member with employee id : "+fclt.get(Faculty.fcount).RetEmpId()+"added successfully!!\n");
    }
    public int SearchStudent(String r){
        for(int i=0;i<std.size();i++)
            if(std.get(i).RetRoll().equals(r))
                return i;
        return -1;
    }
    public int SearchFaculty(String r1){
        for(int i=0;i<fclt.size();i++)
            if(fclt.get(i).RetEmpId().equals(r1))
                return i;
        return -1;
    }
    public void ChAddress(String p){
        int b=SearchStudent(p);
        if(b==-1)
        {
            b=SearchFaculty(p);
            if(b==-1)
                System.out.println("No such student or faculty member exists!!");
            else{
                fclt.get(b).ChangeAddress();
                System.out.println("Address changed successfully!!\n");
            }

        }
        else
        {
            std.get(b).ChangeAddress();
            System.out.println("Address changed successfully!!\n");
        }
    }
    public void ShowDetails(String d)
    {
        int b=SearchStudent(d);
        if(b==-1)
        {
            b=SearchFaculty(d);
            if(b==-1)
                System.out.println("No such student or faculty member exists!!");
            else
                fclt.get(b).ShowData();
        }
        else
            std.get(b).ShowData();
    }
}
public class InstituteMain{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int ch=1;
        Institute I=new Institute();
        while(ch!=0)
        {
            System.out.println("1. Add student\n2. Add faculty\n3. Change Address\n4. Show Details\nEnter choice");
            int ch1=in.nextInt();
            switch(ch1){
                case 1: I.AddStudents();
                        break;
                case 2: I.AddFaculty();
                        break;
                case 3: System.out.println("Enter the student/faculty id whose address you want to change? : ");
                        String s=in.next();
                        I.ChAddress(s);
                        break;
                case 4: System.out.println("Enter the student/faculty id whose details you want to see? : ");
                        String s1=in.next();
                        I.ShowDetails(s1);
                        break;
                default:System.out.println("Enter a valid choice");
                
            }
            System.out.println("Do you wish to continue? : (0/1) ");
            ch=in.nextInt();
            if(ch==1)
                continue;
            else
                System.exit(0);
        }
      in.close();  
    }
}
/*Output
1. Add student
2. Add faculty
3. Change Address
4. Show Details
Enter choice
1
Enter your name : 
abcd
Enter phone number : 
822911992
Enter email id : 
abc@gmail.com
Enter the premise no. : 
2
Enter street : 
8
Enter city : 
Kolkata
Enter pin : 
729991
Enter State : 
WB
Enter course : 
BCSE
Student with roll no. : BCSE_001 added successfully!!

Do you wish to continue? : (0/1) 
1
1. Add student
2. Add faculty
3. Change Address
4. Show Details
Enter choice
4
Enter the student/faculty id whose details you want to see? : 
BCSE_001
Name : abcd Phone no.  822911992 Email id : abc@gmail.com
Address
Premise no. : 2 Street : 8 City : Kolkata Pin : 729991 State : WB
Course : BCSE Roll no. : BCSE_001
Do you wish to continue? : (0/1) 
0 */