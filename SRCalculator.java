import java.util.Scanner;

public class SRCalculator
{
   public static void main(String[] args)
   {
      Scanner amt = new Scanner(System.in);           //Determine number of users
      System.out.print("Enter number of users: ");
      int amount = amt.nextInt();
      
      double[] userSpamRank = new double[amount];     //Create list with starting SpamRank values for all users
      for (int k=0; k<userSpamRank.length; k++)
         {userSpamRank[k]=0.75;}
      
      user[] users;                                   //Create list of "user" objects that store data for every user
      users = createLinks(amount);

      for(int k=0; k<1000; k++)                       //Perform power iteration algorithm for all users' SpamRank
      {
         for(int a=0; a<amount; a++)
         {
            userSpamRank[a] = solveSR(a, amount, userSpamRank, users);
            System.out.print(userSpamRank[a]+"   ");
         }
         System.out.println(" ");
      }
      System.out.println(" ");
      
      for(int b=0; b<amount; b++)                  //Display SpamRank Value of all Users
         System.out.println("User "+(b+1)+":  "+userSpamRank[b]);
         
   }
   
   
   public static double solveSR(int uN, int a, double[] uR, user[] x)  //Method to perform power iteration algorithm on research method equation
   {
      int[] tempHOutbox = x[uN].getHamOutbox();
      int[] tempSOutbox = x[uN].getSpamOutbox();
        
      double hSR=0.0;
      double sSR=0.0;
      if(tempHOutbox.length!=0)
      {      
         for(int k=0; k<tempHOutbox.length; k++)
         {
            hSR+=uR[tempHOutbox[k]];
         }
      }
      if(tempSOutbox.length!=0)
      {  
         for(int k=0; k<tempSOutbox.length; k++)
         {
            sSR+=uR[tempSOutbox[k]];
         }
      }   
      double temp;
      temp = (0.15) + ((0.85*(hSR-sSR)));
      
      return temp;
   }
   
   public static user[] createLinks(int x)      //Method to store user data on how much ham and spam sent and emails received
   { 
      user[] people = new user[x];
      for (int k=0; k<x; k++)
      {
         System.out.println(" ");
         System.out.println("For user "+ (k+1));
         user temp = new user();
         people[k]=temp;
      }
      return people;
   }
   
   
}