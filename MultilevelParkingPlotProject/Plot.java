package MultilevelParkingPlotProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Plot {
	private String email = "sona@123";
	private String password = "123";
	private Container[] twoWheeler = null;
	private Container[] fourWheeler = null;
	private Container[] heavyWheeler = null;
	private static ArrayList<String> parkedVechicle = new ArrayList<>();

	public static boolean isVechicleParked(String vechicleNumber) {
		for (int i = 0; i < parkedVechicle.size(); i++) {
			if (parkedVechicle.get(i).contains(vechicleNumber)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)) == false)
				return false;

		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Container[] getTwoWheeler() {
		return twoWheeler;
	}

	public void setTwoWheeler(Container[] twoWheeler) {
		this.twoWheeler = twoWheeler;
	}

	public Container[] getFourWheeler() {
		return fourWheeler;
	}

	public void setFourWheeler(Container[] fourWheeler) {
		this.fourWheeler = fourWheeler;
	}

	public Container[] getHeavyWheeler() {
		return heavyWheeler;
	}

	public void setHeavyWheeler(Container[] heavyWheeler) {
		this.heavyWheeler = heavyWheeler;
	}

	public ArrayList<String> getParkedVechicle() {
		return parkedVechicle;
	}

	public void setParkedVechicle(ArrayList<String> parkedVechicle) {
		this.parkedVechicle = parkedVechicle;
	}

	public static boolean check(String str) {
		if (isNumber(str)) { // System.out.println("Integer");
			return true;
		}

		else {// System.out.println("String");
			return false;
		}
	}

	public static void seeLot(Container[] arr, String name) {
		System.out.print(name + "-----");
		for (int i = 0; i < arr.length; i++) {
			int c = i + 1;
			if (arr[i] != null) {
				System.out.print("[" + c + "  vehicle " + "]");
			} else {
				{
					System.out.print("[  " + c + "  Not-vehicle" + "]");
				}
			}

		}
		System.out.println("");

	}

	public static void viewParkingLot(Plot admin) {
		if (admin.twoWheeler == null || admin.fourWheeler == null || admin.heavyWheeler == null) {
			System.out
					.println(" firstly You should InitializeLot The plot then You can able the to see the Lot........");
			// InitializeLot(admin);
		}

		else {

			seeLot(admin.twoWheeler, "two_wheeler");
			seeLot(admin.fourWheeler, "fourwheeler");
			seeLot(admin.heavyWheeler, "heavy_wheeler");

		}
	}

	public static void InitializeLot(Plot admin) { // working..........
		if (admin.twoWheeler != null) {
			System.out.println("Admin has already Initialize...............");
		} else {
			Scanner sc = new Scanner(System.in);
			boolean f = true;
			while (f) {
				System.out.println("Enter the Number of two_wheeler Lot");
				String str = sc.next();
				if (check(str)) {
					int size = Integer.parseInt(str);
					admin.twoWheeler = new Container[size];
					f = false;

				} else {
					System.out.println("You Enter the someThing worng........plz enter the valid Number....");
				}
			}
			f = true;
			while (f) {
				System.out.println("Enter the Number of four_wheeler Lot");
				String str = sc.next();
				if (check(str)) {
					int size = Integer.parseInt(str);
					admin.fourWheeler = new Container[size];
					f = false;

				} else {
					System.out.println("You Enter the someThing worng........plz enter the valid Number....");
				}
			}
			f = true;
			while (f) {
				System.out.println("Enter the Number of heavy_wheeler Lot");
				String str = sc.next();
				if (check(str)) {
					int size = Integer.parseInt(str);
					admin.heavyWheeler = new Container[size];
					f = false;

				} else {
					System.out.println("You Enter the someThing worng........plz enter the valid Number....");
				}
			}
		}

	}

	public static void parkTheVehicle(Plot plot, int n) {

		boolean f = true;
		String vechicleNumber = null;
		while (f) {
			System.out.println("Enter the  vehicle number ................");

			Scanner sc = new Scanner(System.in);
			vechicleNumber = sc.next();
			if (isVechicleParked(vechicleNumber)) {

				System.out.println("Vehicle is already parked.");
				return;
			}
			if (Ticket.isValidVechicleNumber(vechicleNumber)) {
				if (plot.parkedVechicle.size() != 0) {
					int c = 0;
					for (int i = 0; i < plot.parkedVechicle.size(); i++) {
						if (plot.parkedVechicle.get(i).equals(vechicleNumber)) {
							{
								System.out.println("This  vehicle has already park........");
								c = 1;
							}
						}

					}
					if (c == 0) {
						f = false;
						plot.parkedVechicle.add(vechicleNumber);
					}

				} else {
					f = false;
					plot.parkedVechicle.add(vechicleNumber);
				}

			} else {
				System.out.println("You enter the Wrong  vehicle number");
			}
		}
		// ...................................................................................................
		if (n == 1)

		{
			// two_wheeler
			System.out.println("two_wheeler parking area.........");

			boolean ff = true;
			for (int i = 0; i < plot.twoWheeler.length; i++) {
				if (ff) {
					if (plot.twoWheeler[i] == null) {
						int c = i + 1;
						System.out.println("you park plot number " + c);
						plot.twoWheeler[i] = new Container();
						plot.twoWheeler[i].p = true;
						plot.twoWheeler[i].t = new Ticket(c, vechicleNumber);
						Ticket.showTicket(plot.twoWheeler[i].t);
						ff = false;
						break;
					}
				}

			}
			if (ff) {
				System.out.println("there is no area To park............");
			}
		} else if (n == 2) {

			// four_wheeler
			System.out.println("four_wheeler parking area.........");

			boolean ff = true;
			for (int i = 0; i < plot.fourWheeler.length; i++) {
				if (ff) {
					if (plot.fourWheeler[i] == null) {
						System.out.println("you park plot number " + i + 1);
						plot.fourWheeler[i] = new Container();
						plot.fourWheeler[i].p = true;
						plot.fourWheeler[i].t = new Ticket(i + 1, vechicleNumber);
						Ticket.showTicket(plot.fourWheeler[i].t);
						ff = false;
					}
				}

			}
			if (ff) {
				System.out.println("there is no area To park............");
			}
		} else if (n == 3) {

			// heavy_wheeler
			System.out.println("four_wheeler parking area.........");
			boolean ff = true;
			for (int i = 0; i < plot.fourWheeler.length; i++) {
				if (ff) {
					if (plot.heavyWheeler[i] == null) {
						System.out.println("you park plot number " + i + 1);
						plot.heavyWheeler[i] = new Container();
						plot.heavyWheeler[i].p = true;
						plot.heavyWheeler[i].t = new Ticket(i + 1, vechicleNumber);
						Ticket.showTicket(plot.heavyWheeler[i].t);
						ff = false;
					}
				}

			}
			if (ff) {
				System.out.println("there is no area To park............");
			}

		}
	}

	public void UnparkTheVehicle(Plot admin, int n) {

		if (n == 1 && admin.twoWheeler == null || (n == 2 && admin.fourWheeler == null)
				|| (n == 3 && admin.heavyWheeler == null)) {
			System.out.println("there is no vehicle.........");
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Plz enter the vechicle_number");
			String v_no = sc.next();
//  		  if(check(str)) {
//  			   plot_no=Integer.parseInt(str);
//  		  }
//  		  else {
//  			  System.out.println("You Enter the wrong.......");
//  			    return;
//  		  }

			if (n == 1) { // two_wheeler
				if (admin.twoWheeler == null) {
					System.out.println("No vehicle park here..............");
				} else {
					int ans = 0;
					for (int i = 0; i < admin.twoWheeler.length; i++) {

						if (admin.twoWheeler[i] != null) {
							if (admin.twoWheeler[i].t.v_no.equals(v_no)) {
								System.out.println("Your vehicle is here");
								ans = 1;
								Ticket.TicketShowOut(admin.twoWheeler[i].t);
								admin.twoWheeler[i] = null;
								admin.parkedVechicle.remove(v_no);
							}

						}

					}
					if (ans == 0) {
						System.out.println("There is no vehicle " + v_no + " of this number");
					}

				}
			} else if (n == 2) {

				// four_wheeler
				if (admin.fourWheeler == null) {
					System.out.println("No vehicle park here..............");
				} else {
					int ans = 0;
					for (int i = 0; i < admin.fourWheeler.length; i++) {

						if (admin.fourWheeler[i] != null) {
							if (admin.fourWheeler[i].t.v_no.equals(v_no)) {
								System.out.println("Your vehicle is here");
								ans = 1;
								Ticket.TicketShowOut(admin.fourWheeler[i].t);
								admin.twoWheeler[i] = null;
								admin.parkedVechicle.remove(v_no);
							}

						}

					}
					if (ans == 0) {
						System.out.println("There is no vehicle " + v_no + " of this number");
					}

				}

			} else if (n == 3) { // heavy_wheeler
				if (admin.heavyWheeler == null) {
					System.out.println("No vehicle park here..............");
				} else {
					int ans = 0;
					for (int i = 0; i < admin.heavyWheeler.length; i++) {

						if (admin.heavyWheeler[i] != null) {
							if (admin.heavyWheeler[i].t.v_no.equals(v_no)) {
								System.out.println("Your vehicle is here");
								ans = 1;
								Ticket.TicketShowOut(admin.heavyWheeler[i].t);
								admin.twoWheeler[i] = null;
								admin.parkedVechicle.remove(v_no);
							}

						}

					}
					if (ans == 0) {
						System.out.println("There is no vehicle " + v_no + " of this number");
					}

				}

			}
		}

	}

	public void switchCaseAdmin(Plot admin, int choice) {
		Scanner sc = new Scanner(System.in);

		switch (choice) {
		case 1: {
			viewParkingLot(admin);
		}
			break;
		case 2: {
			InitializeLot(admin);
		}
			break;
		case 3: {
			if (admin.twoWheeler == null || admin.fourWheeler == null || admin.heavyWheeler == null) {
				System.out.println(
						" firstly You should InitializeLot The plot then You can park the any types of vechile.....");
				// InitializeLot(admin);
			} else {
				boolean f = true;
				while (f) {
					System.out.println("1.  two_wheeler \n2. four_wheeler\n3.  heavy_wheeler");
					String str = sc.next();
					if (check(str)) {
						int n = Integer.parseInt(str);
						if (n >= 1 && n <= 3) {

							parkTheVehicle(admin, n);
							f = false;
						} else {
							System.out.println("enter the valid detail");
						}
					} else {
						System.out.println("You enter the wrong  detail....");
					}
					// ParkTheVehicle(admin);
				}
			}
		}

			break;
		case 4: {
			// UnparkTheVehicle();
			if (admin.twoWheeler == null || admin.fourWheeler == null || admin.heavyWheeler == null) {
				// System.out.println(" firstly You should InitializeLot The plot then You can
				// park the any types of vechile.....");
				// InitializeLot(admin);
				System.out.println("There is no vechicle...............");
			} else {
				// boolean f=true;
				// while(f) {
				System.out.println("1.  two_wheeler \n2. four_wheeler\n3.  heavy_wheeler");
				String str = sc.next();
				if (check(str)) {
					int n = Integer.parseInt(str);
					if (n >= 1 && n <= 3) {
						UnparkTheVehicle(admin, n);
						// f=false;
					} else {
						System.out.println("Enter the valid detail....................");
						System.out.println();
					}
				} else {
					System.out.println("You enter the wrong  detail....");
				}
				// ParkTheVehicle(admin);
			}
			// }
		}
			break;
		case 5: {
			System.out.println("Exit thank You..........");

		}
			break;
		}

	}

	public void viewAdmin(Plot admin) {
		boolean f = true;
		while (f) {
			System.out.println("1   view parking Lot");
			System.out.println("2   Initialize the parking Lot");
			System.out.println("3   Park the vehicle");
			System.out.println("4   Unpark the vehicle");
			System.out.println("5   Exit");
			Scanner sc = new Scanner(System.in);

			String choice = sc.next();

			if (check(choice)) {
				int c = Integer.parseInt(choice);
				if (c >= 1 && c < 5) { // f=false;
					admin.switchCaseAdmin(admin, c);

				} else if (c == 5) {
					f = false;
					System.out.println("Exit");
				} else {
					System.out.println("you enter valid Number plzzz");
				}

			} else {
				System.out.println("Enter the someThing wrong");

			}

		}
	}

	public static Plot validation(Plot plot) { // Admin admin=new Admin();
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("Enter the Email");

			String Email = sc.next();
			System.out.println("Enter the Password");

			String password = sc.next();
			// System.out.println("Email and password " + Email +" "+ password);

			if (Email.equals(plot.getEmail()) && password.equals(plot.getPassword())) {
				System.out.println("You are Login");
				plot.viewAdmin(plot);
				// return admin;
				f = false;
			} else {
				System.out.println("Oops.......... something wrong");
				System.out.println("you want to Enter Email and  password  again Y/N");

				char c = sc.next().charAt(0);

				if (!(c == 'y' || c == 'Y'))
					f = false;

			}

		}
		System.out.println("thanks.................");
		return plot;

	}
}
