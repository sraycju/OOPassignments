import java.util.*;

class NegativeDistanceException extends Exception{
    NegativeDistanceException()
    {
        super("Distance must be non-negative");
    } 
}

public class Metric {
    static double ConvertintoKm(double miles)throws NegativeDistanceException
    {
        if(miles<0)
            throw new NegativeDistanceException();
       double km=1.5*miles;
       return km;//1 mile=1.5km   
    }
    static double ConvertintoMiles(double km)throws NegativeDistanceException{
        if(km<0)
            throw new NegativeDistanceException();
        double miles=km/1.5;
        return miles;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try{
            //Scanner in  =   new Scanner(System.in);
            System.out.print("Enter Distance in Miles  : ");
            double miles   =  in.nextDouble();
            System.out.println(miles+" Miles equal to : "+ConvertintoKm(miles)+" Kms");
            
            System.out.print("Enter Distance in Kilometers  : ");
            double kms   =   in.nextDouble();
            System.out.println(kms+" Kms equal to : "+ConvertintoMiles(kms)+" Miles");
        }
        catch(Exception E){
            System.err.println("Exception : "+E.getMessage());
        }
        in.close();

    }
    
}
/*Output
 Enter Distance in Miles  : 100
100.0 Miles equal to : 150.0 Kms
Enter Distance in Kilometers  : 200
200.0 Kms equal to : 133.33333333333334 Miles*/