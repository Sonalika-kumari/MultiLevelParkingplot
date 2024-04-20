package MultilevelParkingPlotProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	private String Email = "sona@123";
	private String Password = "123";
	Plot[] plot = null;
	// ArrayList<String> arr=new ArrayList<>();

	public void showPlot(Plot[] plot) {

		if (plot != null) {
			for (int i = 0; i < plot.length; i++) {
				if (plot[i] != null) {
					System.out.println("plot " + i + "");
					plot[i].viewParkingLot(plot[i]);
					System.out.println();
				} else {
					System.out.println("plot " + i + ". There is no parking area in This plot");
				}

			}
		} else {
			System.out.println("There is Not plot............");
		}
	}

	public void initializeNumberOfPlot(Admin admin) {
		if (admin.plot != null) {
			System.out.println("Admin has already Initialize the plot............");
			return;
		}
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of plot that you want to initialize");
		String str = sc.next();
		if (Plot.check(str)) {
			int size = Integer.parseInt(str);
			plot = new Plot[size];
		} else {
			System.out.println("Please enter only number");
		}
	}

	public void switchCase(Admin admin) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println(
					"1. Initialize number of plot \n2. Show all plot \n3. You want to initialize any parking area in any floor \n4. Exit");
			String str = sc.next();
			if (Plot.check(str)) {
				int n = Integer.parseInt(str);
				if (n == 1) {
					if (Plot.check(str)) {
						int size = Integer.parseInt(str);

						// admin.plot=new Plot[size];
						admin.initializeNumberOfPlot(admin);
						// See parking area
					} else {
						System.out.println("Please Enter the number only......");
					}
				} else if (n == 2) {
					admin.showPlot(admin.plot);
				} else if (n == 3) {
					if (admin.plot == null) {
						System.out.println("Firstly Admin Must be Initialize floor");
					} else {
						boolean ff = true;
						while (ff) {
							int num = plot.length - 1;
							System.out.println("Which floor You want to Initialize..0 to " + num);
							String str1 = sc.next();
							if (Plot.check(str1)) {
								int floor = Integer.parseInt(str1);
								if (floor >= 0 && floor < plot.length) {
									if (plot[floor] != null) {
										System.out.println("This Plot has already Created.....");
										ff = false;
									} else {
										plot[floor] = new Plot();
										Plot.InitializeLot(plot[floor]);
										ff = false;
									}
								} else {
									System.out.println("Plzz Enter in range......");
								}
							} else {
								System.out.println("Enter the valid number");
							}

						}
					}
				} else if (n == 4) {
					f = false;

				}

			} else {
				System.out.println("Plzz...... Enter the valid Detail");
			}
		}
	}

	public static Admin checkValidation(Admin admin) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("Enter the email");

			String Email = sc.next();
			System.out.println("Enter the password");

			String password = sc.next();
			// System.out.println("Email and password " + Email +" "+ password);

			if (Email.equals(admin.Email) && password.equals(admin.Password)) {
				System.out.println("You are login");

				f = false;
			} else {
				System.out.println("Oops.......... something wrong");
				System.out.println("you want to Enter Email and  password  again Y/N");

				char c = sc.next().charAt(0);

				if (!(c == 'y' || c == 'Y'))
					f = false;

			}

		}
		// System.out.println("thanks.................");
		return admin;

	}

	public static void main(String args[]) {
		Admin admin = new Admin();
		admin.switchCase(admin);

	}
}
