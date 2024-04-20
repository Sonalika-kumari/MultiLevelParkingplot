package MultilevelParkingPlotProject;

import java.util.Scanner;

public class User2 {
	public static void switchCaseUser(Admin admin, int c) {
		Scanner sc = new Scanner(System.in);
		if (admin.plot == null) {
			System.out.println("There is no plot in this building. Admin must is initialize the plot firstly.");
		   return;
		} 
		
		 int l = admin.plot.length - 1;
		
		System.out.println("Enter the floor that you want to park 0 To " + l);
		 String s = sc.next();

	  	if (Plot.check(s)) {
			 int floor = Integer.parseInt(s);
	     if(floor>=0 && floor<admin.plot.length) {
		 if (c == 1) {
			if (admin.plot[floor] == null) {
				System.out.println("There is no parking area firstly admin must be create space for parking.");
			} else {
				// Plot.parkTheVehicle(admin,);
				admin.plot[floor].switchCaseAdmin(admin.plot[floor], 3);
			}
		 }
		 else if (c == 2) {
			
			if (admin.plot[floor] == null) {
				System.out.println("There is no parking area firstly admin must be create space for parking");
			} else {
				// Plot.parkTheVehicle(admin,);
				admin.plot[floor].switchCaseAdmin(admin.plot[floor], 4);
			}
		  
	    }
	     }
	     else {
	    	 System.out.println("Enter in range..");
	     }
		 }
	  	else {
	  		System.out.println("Invalid Input..");
	  	}
	}

	

	public static void userCall(Admin admin) {
		System.out.println("Welcome User");

		boolean f = true;
		while (f) {

			System.out.println("1   Park  vehicle");
			System.out.println("2   Unpark the vehicle");
			System.out.println("3   Exit");
			Scanner sc = new Scanner(System.in);

			String choice = sc.next();

			if (Plot.check(choice)) {
				int c = Integer.parseInt(choice);
				if (c >= 1 && c < 3) {
					User2.switchCaseUser(admin, c);

				} else if (c == 3) {
					f = false;
					System.out.println("Exit.");
				} else {
					System.out.println("you enter valid number please.");
				}

			} else {
				System.out.println("Invalid input.");

			}

		}
		System.out.println("Thank you.");

	}

	public static void main(String args[]) {
		userCall(new Admin());

	}
}
