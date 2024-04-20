package MultilevelParkingPlotProject;

import java.util.Scanner;

public class User {
	private static boolean isCorrectPlot(Plot plot) {
		if (plot.getTwoWheeler() == null || plot.getFourWheeler() == null || plot.getHeavyWheeler() == null) {
			return false;
		}
		return true;
	}

	public static void switchCaseUser(Plot plot, int choice) {
		Scanner sc = new Scanner(System.in);
		// 1, 2,3
		switch (choice) {
		case 1: {
			if (isCorrectPlot(plot)) {
				System.out.println(" There is no parking area....");
				System.out.println("Firstly admin must be Initialize the parking area");

			} else {
				boolean f = true;
				while (f) {
					System.out.println("1.  two_wheeler \n2. four_wheeler\n3.  heavy_wheeler");
					String str = sc.next();
					if (Plot.check(str)) {
						int n = Integer.parseInt(str);
						if (n >= 1 && n <= 3) {
							Plot.parkTheVehicle(plot, n);
							f = false;
						} else {
							System.out.println("enter the valid detail");
						}
					} else {
						System.out.println("You entered the wrong  detail...");
					}
				}
			}
		}

			break;
		case 2: {
			if (isCorrectPlot(plot)) {
				System.out.println("There is no vechicle...");
			} else {
				// boolean f=true;
				// while(f) {
				System.out.println("1.  two_wheeler \n2. four_wheeler\n3.  heavy_wheeler");
				String str = sc.next();
				if (Plot.check(str)) {
					int n = Integer.parseInt(str);
					if (n >= 1 && n <= 3) {
						plot.UnparkTheVehicle(plot, n);
						// f=false;
					} else {
						System.out.println("Enter the valid detail...");
						System.out.println();
					}
				} else {
					System.out.println("You enter the wrong  detail...");
				}
			}
		}
			break;
		case 3: {
			System.out.println("Exit thank You...");

		}
			break;
		}
	}

	public static void userCall(Plot admin) {
		boolean f = true;
		while (f) {

			System.out.println("1   Park the vehicle");
			System.out.println("2   Unpark the vehicle");
			System.out.println("3   Exit");
			Scanner sc = new Scanner(System.in);

			String choice = sc.next();

			if (Plot.check(choice)) {
				int c = Integer.parseInt(choice);
				if (c >= 1 && c < 3) { // f=false;
					User.switchCaseUser(admin, c);

				} else if (c == 3) {
					f = false;
					System.out.println("Exit");
				} else {
					System.out.println("Please enter the valid number.");
				}

			} else {
				System.out.println("Invalid input.");

			}

		}
		System.out.println("Thank you!!");

	}

}
