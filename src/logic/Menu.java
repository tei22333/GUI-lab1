package logic;

public class Menu {
	private String name;
	private int price;
	private int specialPrice;

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
		this.getPrice();
		this.setSpecialPrice();
	}

	public void setName() {
		this.name = name;
	}

	public void setPrice(int price) {
		if (this.price < 0) {
			this.price = 0;
		}
		if (this.price > 200) {
			this.price = 200;
		}
		this.price = price;
	}

	public void setSpecialPrice() {
		if (this.price < 50) {
			this.specialPrice = this.price + 5;
		}
		if (this.price > 50 && this.price <= 100) {
			this.specialPrice = this.price + 10;
		}
		if (this.price > 100) {
			this.specialPrice = this.price + 20;
		}
	}

	public String toString() {
		return this.name + " Price : " + this.price + " (special " + this.specialPrice + ")";
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		if (this.price < 0) {
			this.price = 0;
		}
		if (this.price > 200) {
			this.price = 200;
		}
		return this.price;
	}

	public int getSpecialPrice() {
		return this.specialPrice;
	}

}
