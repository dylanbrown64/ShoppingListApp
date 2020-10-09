package myPackage;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SalesSlip {

	private ArrayList<SalesItem> slip;

	public SalesSlip() {
		slip = new ArrayList<SalesItem>();
	}

	public void addSalesItem(SalesItem s) {
		slip.add(s);
	}

	public String computeTotal() {
		BigDecimal totalCost = new BigDecimal(0);
		for (int i = 0; i < slip.size(); i++) {
			BigDecimal price = new BigDecimal(slip.get(i).getCost());
			BigDecimal quantity = new BigDecimal(slip.get(i).getQuantity());
			price = price.multiply(quantity);
			totalCost = totalCost.add(price);
		}
		String total = String.valueOf(totalCost);
		return total;
	}

	public String constructList() {
		String list = "";
		for (int i = 0; i < slip.size(); i++) {
			list += String.format("%-30s%10s%5s", slip.get(i).getItem(), "$" + slip.get(i).getCost(), slip.get(i).getQuantity());
			list += "\n";
		}
		return list;
	}
}
