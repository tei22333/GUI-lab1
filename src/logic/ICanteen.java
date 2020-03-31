package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ICanteen {
	static Scanner kb = new Scanner(System.in);
	static List<Store> stores = new ArrayList();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while (true) {
			// FILL CODE
			printMain();
			System.out.print("Select a program to do : ");
			int num = kb.nextInt();
			switch (num) {
			case 1:
				System.out.println("---------------------------");
				addStoreHandle(stores);
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				manageStoreHandle(stores);
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				if (showStores(stores)) {
					buyFoodHandle(stores);
				}
				System.out.println("---------------------------");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid input!!");
				break;
			}

		}

	}

	private static boolean addStoreHandle(List<Store> stores) {
		/* Scanner kb = new Scanner(System.in); */
		System.out.print("Store Name : ");
		// FILL CODE1
		String name = kb.nextLine();
		Store nim = new Store(name);
		for (Store x : stores) {
			if (x.getName().equals(name)) {
				return false;
			}
		}
		stores.add(nim);
		System.out.println("The store named " + name + " was added!");
		return true;
	}

	private static boolean manageStoreHandle(List<Store> stores) {
		/* Scanner kb = new Scanner(System.in); */
		// FILL CODE
		showStores(stores);
		System.out.print("Please select store :​ ");
		int num = kb.nextInt();
		if (num - 1 <= stores.size()) {
			stores.get(num - 1).manageProcessHandle();
			return true;
		} else {
			return false;
		}
	}

	private static void buyFoodHandle(List<Store> stores) {
		/* Scanner kb = new Scanner(System.in); */
		// FILL CODE
		System.out.print("Please select store : ");
		int num = kb.nextInt();
		num--;
		stores.get(num).sellProcessHandle();
	}

	public static void printMain() {
		System.out.println("=========== Main Menu ==========");
		System.out.println("What to do?");
		System.out.println("1. Add Store");
		System.out.println("2. Manage Store");
		System.out.println("3. Buy food");
		System.out.println("4. Exit program");
	}

	public static boolean showStores(List stores) {
		// FILL CODE
		if (stores.size() == 0) {
			System.out.println("Please add store first!!");
			return false;
		} else {
			System.out.println("Here are all stores");
			for (Store x : (List<Store>) stores) {
				System.out.println("[" + (stores.indexOf(x.getName()) + 2) + "] " + x.getName());
			}
			return true;
		}
	}
}
