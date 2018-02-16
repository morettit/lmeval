package lm.evaluation.project.model.taxable;

import lm.evaluation.project.model.base.TaxableItem;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class HighTech extends TaxableItem {
	
	private String name;
	private String brand;
	private String typology;
	
	public HighTech(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public String getName() {
		return name;
	}
	
	public HighTech setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public HighTech setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public String getTypology() {
		return typology;
	}
	
	public HighTech setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		HighTech highTech = (HighTech) o;
		
		if (getName() != null ? !getName().equals(highTech.getName()) : highTech.getName() != null) return false;
		if (getBrand() != null ? !getBrand().equals(highTech.getBrand()) : highTech.getBrand() != null) return false;
		return getTypology() != null ? getTypology().equals(highTech.getTypology()) : highTech.getTypology() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
		result = 31 * result + (getTypology() != null ? getTypology().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getBrand()))
				.append(evaluateBlank(getName()))
				.append(" at ")
				.append(getTotalPrice())
				.toString();
	}
	
	public String toStringWithoutTaxes() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getBrand()))
				.append(evaluateBlank(getName()))
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
