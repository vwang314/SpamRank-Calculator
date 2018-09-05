import java.util.Scanner;

public class user
{
   private int[] inbox;
   private int[] hamOutbox;
   private int[] spamOutbox;
     
   public user()
   {
      hamOutbox=setHamOutbox();
      spamOutbox=setSpamOutbox();
      inbox=setInbox();
   }
   
   public int[] getHamOutbox() {return hamOutbox;}
   public int[] getSpamOutbox() {return spamOutbox;}
   public int[] getInbox() {return inbox;}
         
   public int[] setHamOutbox()
   {
      Scanner ns = new Scanner(System.in);
      System.out.print("Enter number of ham emails sent: ");
      int numSent = ns.nextInt();
      
      int[] temp = new int[numSent];
      
      for (int k=0; k<numSent; k++)
      {   Scanner ws = new Scanner(System.in);
         System.out.print("Enter user number ham email was sent to: ");
         int whoSent = ws.nextInt()-1;
         temp[k]=whoSent;
      }
      
      return temp;
   }
   
   public int[] setSpamOutbox()
   {
      Scanner ns = new Scanner(System.in);
      System.out.print("Enter number of spam emails sent: ");
      int numSent = ns.nextInt();
      
      int[] temp = new int[numSent];
      
      for (int k=0; k<numSent; k++)
      {   Scanner ws = new Scanner(System.in);
         System.out.print("Enter user number spam email was sent to: ");
         int whoSent = ws.nextInt()-1;
         temp[k]=whoSent;
      }
      
      return temp;
   }
      
   public int[] setInbox()
   {
      Scanner nr = new Scanner(System.in);
      System.out.print("Enter number of emails received: ");
      int numReceived = nr.nextInt();
      
      int[] temp = new int[numReceived];
      
      for (int k=0; k<numReceived; k++)
      {   Scanner ws = new Scanner(System.in);
         System.out.print("Enter user number email was sent from: ");
         int whoSent = ws.nextInt()-1;
         temp[k]=whoSent;
      }
      
      return temp;
   }
}