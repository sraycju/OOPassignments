import java.util.*;

class NegativeValueException extends Exception{
    NegativeValueException(int i)
    {
        super("Negative value");
    } 
}
class Numeric
{
    private int num;
    Numeric(int n)throws NegativeValueException
    {
        if(n<0)
            throw new NegativeValueException(n);
        num=n;//basic type to object
    }
    public int ObjecttoBasic()
    {
        return num;//object type to basic type
    }
    public String BasictoString(int n)throws NegativeValueException
    {
        if(n<0)
            throw new NegativeValueException(n);
        String str=String.valueOf(n);
        return str;
    }
    public Numeric NumericObject(String s1)throws NegativeValueException
    {
        int i=Integer.valueOf(s1);
        if(i<0)
            throw new NegativeValueException(i);
        Numeric wp=new Numeric(i);//String to Numeric object
        return wp;
    }
    public String ObjectToString()
    {
        String s2=String.valueOf(num);//Object to string
        return s2;
    }
}

public class WrapperMain1 {
   public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int i;
       System.out.printf("Enter an Integer value : ");
       i=sc.nextInt();
       try{
        Numeric w=new Numeric(i);
        System.out.println("Basic data type converted to object");
        int p=w.ObjecttoBasic();
        p=p+4;
        System.out.println("Object converted to basic data type and added 4 to it gives "+p);//Object to basic data type
        String s=w.BasictoString(i);
        s=s+"12";
        System.out.println("Basic data type converted to string and 12 is concatenated to string s : "+s);//Basic data type to string
        System.out.println("Enter a string containing numeric values : ");
        String st=sc.next();
        System.out.println("String of numeric data type converted to numeric object return type : "+w.NumericObject(st).getClass().getName());//String with numeric value to numeric object
        System.out.println("Object converted to string : "+w.ObjectToString());//Object to String
    }
       catch(NegativeValueException e){
            System.err.println("Exception : "+e.getMessage());
       } 
       sc.close();
    }
}
/*Output
Enter an Integer value : 3
Basic data type converted to object
Object converted to basic data type and added 4 to it gives 7
Basic data type converted to string and 12 is concatenated to string s : 312
Enter a string containing numeric values : 
788
String of numeric data type converted to numeric object return type : Numeric
Object converted to string : 3 */