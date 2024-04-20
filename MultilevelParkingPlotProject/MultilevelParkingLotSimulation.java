package MultilevelParkingPlotProject;

import java.util.Scanner;

public class MultilevelParkingLotSimulation {
	private String email = "sona@123";
	private String password = "123";
   
	public static void main(String args[]) {
		Admin admin = new Admin();

		System.out.println("Welcome...");
		boolean f = true;
		while (f) {
			System.out.println("1. Admin \n2. User \n3. Exit");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			if (Plot.check(str)) {
				int n = Integer.parseInt(str);
				if (n == 1) {
					System.out.println("Welcome admin...");
					admin = Admin.checkValidation(admin);
					admin.switchCase(admin);
					// System.out.println("yes");

				} else if (n == 2) {
					// user call
					User2.userCall(admin);
				} else if (n == 3) {
					System.out.println("Thank You ...");
					f = false;
				} else {
					System.out.println("Enter inside the range...");
				}

			} else {
				System.out.println("Enter the valid detail...");
			}
		}

	}

}
