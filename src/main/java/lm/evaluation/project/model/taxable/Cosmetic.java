package lm.evaluation.project.model.taxable;

import lm.evaluation.project.model.base.TaxableItem;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class Cosmetic extends TaxableItem {
	
	private String name;
	private String quantityOfProduct;
	private String typology;
	private String cosmeticIndustry;
	
	public Cosmetic(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public String getName() {
		return name;
	}
	
	public Cosmetic setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getQuantityOfProduct() {
		return quantityOfProduct;
	}
	
	public Cosmetic setQuantityOfProduct(String quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
		return this;
	}
	
	public String getTypology() {
		return typology;
	}
	
	public Cosmetic setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	
	public String getCosmeticIndustry() {
		return cosmeticIndustry;
	}
	
	public Cosmetic setCosmeticIndustry(String cosmeticIndustry) {
		this.cosmeticIndustry = cosmeticIndustry;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Cosmetic cosmetic = (Cosmetic) o;
		
		if (Double.compare(cosmetic.getQuantity(), getQuantity()) != 0) return false;
		if (getName() != null ? !getName().equals(cosmetic.getName()) : cosmetic.getName() != null) return false;
		if (getQuantityOfProduct() != null ? !getQuantityOfProduct().equals(cosmetic.getQuantityOfProduct()) : cosmetic.getQuantityOfProduct() != null) return false;
		if (getTypology() != null ? !getTypology().equals(cosmetic.getTypology()) : cosmetic.getTypology() != null)
			return false;
		return getCosmeticIndustry() != null ? getCosmeticIndustry().equals(cosmetic.getCosmeticIndustry()) : cosmetic.getCosmeticIndustry() == null;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getName() != null ? getName().hashCode() : 0;
		temp = Double.doubleToLongBits(getQuantity());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (getQuantityOfProduct() != null ? getQuantityOfProduct().hashCode() : 0);
		result = 31 * result + (getTypology() != null ? getTypology().hashCode() : 0);
		result = 31 * result + (getCosmeticIndustry() != null ? getCosmeticIndustry().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getCosmeticIndustry()))
				.append(evaluateBlank(getName()))
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getQuantityOfProduct()))
				.append(" at ")
				.append(getTotalPrice())
				.toString();
	}
	
	public String toStringWithoutTaxes() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getCosmeticIndustry()))
				.append(evaluateBlank(getName()))
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getQuantityOfProduct()))
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
