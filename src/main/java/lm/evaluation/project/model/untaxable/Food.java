package lm.evaluation.project.model.untaxable;

import lm.evaluation.project.model.base.UntaxableItem;

import java.util.Date;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class Food extends UntaxableItem {
	
	private Date expirationDate;
	private String typology;
	
	public Food(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public Food setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
		return this;
	}
	
	public String getTypology() {
		return typology;
	}
	
	public Food setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Food food = (Food) o;
		
		if (getExpirationDate() != null ? !getExpirationDate().equals(food.getExpirationDate()) : food.getExpirationDate() != null)
			return false;
		return getTypology() != null ? getTypology().equals(food.getTypology()) : food.getTypology() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getExpirationDate() != null ? getExpirationDate().hashCode() : 0;
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
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
