import java.util.*;

class StringC{
    static final Scanner in=new Scanner(System.in);
    public int Checkfora(String s)
    {
        int count=0;
        char[] ch=s.toLowerCase().toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='a')
            {
                count++;
            }
        }
        return count;
    }
    public int Checkforand(String s1)
    {
        int c=0;    
        String a[]=s1.toLowerCase().split(" ");
        for(int i=0;i<a.length;i++)
        {
            if("and".equals(a[i]))
                c++;
        }
        return c;
    }
    public void StartswThe(String s2)
    {
        System.out.println(s2.startsWith("The")+"\n");
    }
    public void RetToken(String s3)
    {
        StringTokenizer st = new StringTokenizer(s3,"[ ,@,.]");  
        while (st.hasMoreTokens()) {  
         System.out.println(st.nextToken());  
        }
    }
    public void StrtoCharArray(String s4)
    {
        char[] s=s4.toCharArray();
        System.out.println("String converted to character array");
        for(int i=0;i<s.length;i++)
            System.out.print(s[i]);
    }
}
public class StringMain {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
      StringC st=new StringC();
      int ch=1;
      String str;
      while(ch!=0)
      {
          System.out.println("1. No. of times 'a' appears\n2. No. of times 'and' appears\n3. Check if string starts with 'The'\n4. Put string into array of characters\n5. Display tokens in the string\nEnter a choice");
          int ch1=sc.nextInt();
          System.out.println("Enter a sentence : ");
          str=sc.next();
          
          switch(ch1)
          {
                case 1: System.out.println("No. of a(s) is : "+st.Checkfora(str)); 
                        break;
                case 2: System.out.println("No. of and(s) : "+ st.Checkforand(str));
                        break;
                case 3: st.StartswThe(str);
                        break;
                case 4: st.StrtoCharArray(str);
                        break;
                case 5: System.out.println("Tokens separated by @ are \n");
                        st.RetToken(str);
                        break;
                default:System.out.print("Enter a valid choice");
          }
          System.out.println("\nDo you wish to continue? (0/1) : ");
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
 1. No. of times 'a' appears
2. No. of times 'and' appears
3. Check if string starts with 'The'
4. Put string into array of characters
5. Display tokens in the string
Enter a choice
1
Enter a sentence : 
Java Object Oriented Programming
No. of a(s) is : 3

Do you wish to continue? (0/1) : 
*/