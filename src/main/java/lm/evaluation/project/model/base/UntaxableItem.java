package lm.evaluation.project.model.base;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 13/02/2018
 * @description
 */
public abstract class UntaxableItem extends Item {
	
	public UntaxableItem(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	/**
	 * This is only a simple wrapper for importation taxes,
	 * because this items could not be taxed
	 * @return unitary taxes rounded at 0.05
	 */
	public BigDecimal getTaxes() {
		return getImportationTaxes();
	}
}
