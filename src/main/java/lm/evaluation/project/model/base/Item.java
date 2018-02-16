package lm.evaluation.project.model.base;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 13/02/2018
 * @description Base representation of a commercial good
 * All items have a description and a price
 * All items are importable, so all items could have importation taxes
 */
public abstract class Item {
	
	private String description;
	private int quantity;
	private float price;
	private boolean imported;
	
	Item(String description, int quantity, float price, boolean imported) {
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.imported = imported;
	}
	
	public String getDescription() {
		return isImported() ? "imported " + description : description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Item setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	
	float getPrice() {
		return price;
	}
	
	private boolean isImported() {
		return imported;
	}
	
	/**
	 * @return unitary taxes rounded at 0.05
	 */
	BigDecimal getImportationTaxes() {
		return isImported()
				? BigDecimal.valueOf(Math.ceil(getPrice())/20)
					.setScale(2,BigDecimal.ROUND_HALF_UP)
				: BigDecimal.valueOf(0.00);
	}
	
	protected abstract BigDecimal getTaxes();
	
	public BigDecimal getTotalTaxes() {
		return getTaxes()
				.multiply(BigDecimal.valueOf(getQuantity()));
	}
	
	public BigDecimal getTotalPrice() {
		return getTaxes()
				.add(BigDecimal.valueOf(getPrice()))
				.multiply(BigDecimal.valueOf(getQuantity()))
				.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
	@Override
	public String toString() {
		StringBuilder stringify = new StringBuilder();
		stringify.append(getQuantity());
		stringify.append(" ");
		stringify.append(getDescription());
		stringify.append(" at ");
		stringify.append(getTotalPrice());
		return stringify.toString();
	}
	
	public abstract String toStringWithoutTaxes();
}
