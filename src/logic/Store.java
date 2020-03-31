package logic;

import java.util.ArrayList;
/*import java.util.ArrayList;*/
import java.util.List;
import java.util.Scanner;

public class Store {
	private String name;
	private int totalSales;
	private List<Record> records = new ArrayList();
	private List<Menu> menus = new ArrayList();

	public Store(String name) {
		this.name = name;
	}

	public void sell(Menu menu, boolean isSpecial) {
		// FILL CODE
		if (!isSpecial) {
			Record x = new Record(menu.getName(), menu.getPrice());
			this.totalSales += menu.getPrice();
			this.records.add(x);
			System.out.println("Please select valid menu.");
			System.out.println("Thank you for buying " + menu.getName() + " " + menu.getPrice() + " Bath");
		} else {
			Record x = new Record(menu.getName(), menu.getSpecialPrice());
			this.totalSales += menu.getSpecialPrice();
			this.records.add(x);
			System.out.println("Please select valid menu.");
			System.out.println("Thank you for buying " + menu.getName() + " " + menu.getSpecialPrice() + " Bath");
		}
	}

	public void sellProcessHandle() {
		// FILL CODE
		Scanner kb = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("Welcome to " + this.name);
		System.out.println("---------------------------");
		if (this.menus.size() == 0) {
			System.out.println("Please add menu first");
		} else {
			for (Menu e : this.menus) {
				System.out.println("[" + (this.menus.indexOf(e) + 1) + "] " + e.getName() + " " + e.getPrice()
						+ " Price : " + e.getPrice() + "(special" + e.getSpecialPrice() + ")");
			}
			System.out.print("Please select menu : ");
			int num = kb.nextInt();
			System.out.print("Upgrade to special ? (Y/N) :");
			String spe = kb.next();
			num--;
			if (spe.equals("Y")) {
				this.totalSales += this.menus.get(num).getSpecialPrice();
				Record x = new Record(this.menus.get(num).getName(), this.menus.get(num).getSpecialPrice());
				System.out.println("Thank you for buying " + this.menus.get(num).getName() + " "
						+ this.menus.get(num).getSpecialPrice() + " Bath");
				this.records.add(x);
			} else if (spe.equals("N")) {
				this.totalSales += this.menus.get(num).getPrice();
				Record x = new Record(this.menus.get(num).getName(), this.menus.get(num).getPrice());
				System.out.println("Thank you for buying " + this.menus.get(num).getName() + " "
						+ this.menus.get(num).getPrice() + " Bath");
				this.records.add(x);
			}
		}
	}

	public void manageProcessHandle() {
		Scanner kb = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("Welcome to " + this.name);
		System.out.println("---------------------------");
		System.out.println("1. Add menu");
		System.out.println("2. Show summary");
		System.out.println("Select a program to do : ");
		int prog = kb.nextInt();
		if (prog == 1) {
			this.addMenuHandle();
		} else {
			this.showSummary();
		}
	}

	private void addMenuHandle() {
		// FILL HERE
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter menu name :");
		String name = kb.nextLine();
		System.out.println("Please enter price :");
		int price = kb.nextInt();
		Menu newMenu = new Menu(name, price);
		boolean cker = true;
		for (Menu e : this.menus) {
			if (e.getName().equals(newMenu.getName())) {
				cker = false;
				break;
			}
		}
		if (cker) {
			this.menus.add(newMenu);
			System.out.println("New menu " + name + " added!");
		}
	}

	private void showSummary() {
		// FILL CODE
		System.out.println("Total Sales : " + this.totalSales);
		for (Record x : this.records) {
			System.out.println("Menu : " + x.getFoodName() + " sold in " + x.getSoldPrice() + " THB");
		}

	}

	public void showAllMenu() {
		System.out.println(menus.toArray().toString());
	}

	public void addRecord(Record record) {
		records.add(record);
	}

	public List getMenus() {
		return this.menus;
	}

	public String getName() {
		return this.name;
	}

	public int getTotalSales() {
		return this.totalSales;
	}

	public boolean addMenu(Menu menu) {
		for (Menu e : this.menus) {
			if (menu.getName().equals(e.getName())) {
				return false;
			}
		}
		this.menus.add(menu);
		if (this.menus.contains(menu)) {
			return true;
		}
		return false;
	}

	public List getRecords() {
		return this.records;
	}
}
