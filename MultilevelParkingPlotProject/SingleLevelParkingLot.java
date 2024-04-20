package MultilevelParkingPlotProject;

import java.util.Scanner;

public class SingleLevelParkingLot {
	public static Plot switchCase(int choice, Plot plot) {

		switch (choice) {
		case 1: {
			System.out.println("Welcome  Admin");
			plot = Plot.validation(plot);
		}
			break;
		case 2: {
			System.out.println("Welcome User");
			// user call
			// Admin.parkTheVehicle(null, choice);
			if (plot.getTwoWheeler() == null || plot.getFourWheeler() == null || plot.getHeavyWheeler() == null) {
				System.out.println("Firstly Admin must be Initialize the parking area then You can park the Vechicle");
			} else {
				User.userCall(plot);
			}
		}

			break;
		}
		return plot;

	}

	public static void main(String args[]) {
		System.out.println("sonalika kumari");
		System.out.println("Welcome In  Parking Lot");

		Scanner sc = new Scanner(System.in);
		Plot admin = new Plot();
		boolean f = true;
		while (f) {
			System.out.println("1. Admin \n2. User \n3. Exit");
			// int choice=sc.nextInt();
			String choice = sc.next();
			if (Plot.check(choice)) {
				int c = Integer.parseInt(choice);
				if (c == 1 || c == 2) {
					admin = switchCase(c, admin);

				} else if (c == 3) {
					f = false;
				} else {
					System.out.println("enter the valid Number");
				}

			} else {
				System.out.println("You enter the someThing wrong please enter the once again");
			}

		}
		System.out.println("Thank you...");
	}
}
