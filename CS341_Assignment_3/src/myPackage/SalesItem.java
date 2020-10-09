package myPackage;

public class SalesItem {
	private String item;
	private String cost;
	private String quantity;
	
	public SalesItem(String i, String c, String q) {
		item = i;
		cost = c;
		quantity = q;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
