import lm.evaluation.project.model.taxable.Cosmetic;
import lm.evaluation.project.model.untaxable.Food;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 16/02/2018
 */
public class Input2 {
	
	@Test
	public void Input2Chart() {
		BigDecimal expectedTotalPrice = new BigDecimal(65.15).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotalTaxes = new BigDecimal(7.65).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("Input2:");
		Food f = new Food("box of chocolates", 1, (float)10.00,true);
		Cosmetic c = new Cosmetic("bottle of perfume",1,(float)47.50,true);
		System.out.println(c.toStringWithoutTaxes());
		System.out.println(f.toStringWithoutTaxes());
		System.out.println("Output1:");
		System.out.println(c.toString());
		System.out.println(f.toString());
		BigDecimal totalTaxes = c.getTotalTaxes()
				.add(f.getTotalTaxes());
		BigDecimal totalPrice = c.getTotalPrice()
				.add(f.getTotalPrice());
		System.out.println("Sales Taxes: "+totalTaxes);
		System.out.println("Total: "+totalPrice);
		Assert.assertTrue(totalTaxes.equals(expectedTotalTaxes));
		Assert.assertTrue(totalPrice.equals(expectedTotalPrice));
	}
}
