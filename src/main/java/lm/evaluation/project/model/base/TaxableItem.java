package lm.evaluation.project.model.base;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 13/02/2018
 */
public abstract class TaxableItem extends Item {
	
	public TaxableItem(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	/**
	 * This is a wrapper for taxes applied
	 * @return unitary taxes rounded at 0.05
	 */
	protected BigDecimal getTaxes() {
		return getImportationTaxes()
				.add(BigDecimal.valueOf(getPrice()/10))
				.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
}
