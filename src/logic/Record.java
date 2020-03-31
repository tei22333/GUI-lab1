package logic;

public class Record {
	String foodName;
	private int soldPrice;

	public Record(String foodName, int soldPrice) {
		this.foodName = foodName;
		this.soldPrice = soldPrice;
	}

	public String toString() {
		return "Menu : " + this.foodName + " sold in " + this.soldPrice + " THB";
	}

	public String getFoodName() {
		return this.foodName;
	}

	public int getSoldPrice() {
		return this.soldPrice;
	}
}
