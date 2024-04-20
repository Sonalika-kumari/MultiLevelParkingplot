package MultilevelParkingPlotProject;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


public class Ticket {
   String id;
   String v_no;
   int slot_no;
   Date in_time; 
   Date out_time;
   public String generateId() {
	   String Uuid = UUID.randomUUID().toString();
	 
	    //System.out.println(Uuid);
	   
	      return Uuid;
	  
	   
	}
   Ticket()
   {
	   
   }
   public static void TicketShowOut(Ticket t)
   {  System.out.println("This.is Your Ticket details..................................");
	   System.out.println("ID\t" +t.getId());
	   System.out.println("vechile number\t"+t.v_no);
	   System.out.println("slot  number\t"+t.slot_no);
	   System.out.println("In_ Time\t"+t.getIn_time());
	   java.util.Date date = new java.util.Date();
	   System.out.println("Out_time\t"+ date);
   }
   public static void showTicket(Ticket t)
   {   System.out.println("This is Your ticket details...................................");
	   System.out.println("ID\t" +t.getId());
	   System.out.println("vechile number\t"+t.v_no);
	   System.out.println("slot  number\t"+t.slot_no);
	   System.out.println("In_ Time\t"+t.getIn_time());
	   System.out.println("Out_time\t"+ " 0 ");
	   System.out.println("Done....................................................");
   }
   public static boolean checkchar(char c)
   { if(c>='a' && c<='z' || c>='A' && c<='Z')
	      return true;
       return false;
	   
   }
   public static boolean checkNum(char c)
   {
	   if(c>='0' && c<='9')
		     return true;
	   else
		   return false;
   }

	public static boolean isValidVechicleNumber(String ticketNumber)
   { if(ticketNumber.length()!=10)
	      return false;
     else {
	   if(checkchar(ticketNumber.charAt(0)) && checkchar(ticketNumber.charAt(1)) && checkNum(ticketNumber.charAt(2)) &&checkNum(ticketNumber.charAt(3))&&checkchar(ticketNumber.charAt(4)) &&checkchar(ticketNumber.charAt(5)) &&checkNum(ticketNumber.charAt(6))&&checkNum(ticketNumber.charAt(7))&&checkNum(ticketNumber.charAt(8))&&checkNum(ticketNumber.charAt(9)) ) {
		     return true;
       }
	   return false;
   }	  
   }
   Ticket(int slot,String v_Num)
   {  //char[] ch= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	   //    String v_Num=ch[generateId(0,25)]+""+ch[generateId(0,25)] +""+generateId(100,99)+ch[generateId(0,25)]+ch[generateId(0,25)]+generateId(1000,9999);
    
	     //......................................................
	  id=""+generateId();
	  v_no=v_Num;
	  slot_no=slot;
	  java.util.Date date = new java.util.Date();    
	 // System.out.println(date);
	  in_time=date;
	  out_time=null;
	  
	  	  
   }
 public String getId() {
	return id;
}
public void setId(String id) {
	
	this.id = id;
}
public String getV_no() {
	return v_no;
}
public void setV_no(String v_no) {
	this.v_no = v_no;
}
public int getSlot_no() {
	return slot_no;
}
public void setSlot_no(int slot_no) {
	this.slot_no = slot_no;
}
public Date getIn_time() {
	return in_time;
}
public void setIn_time(Date in_time) {
	this.in_time = in_time;
}
public Date getOut_time() {
	return out_time;
}
public void setOut_time(Date out_time) {
	this.out_time = out_time;
}
public static void main(String arg[])
{
	System.out.println("sonalika");
	//Ticket t=new Ticket(2);
}


  
}
