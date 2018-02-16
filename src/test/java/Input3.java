import lm.evaluation.project.model.taxable.Cosmetic;
import lm.evaluation.project.model.untaxable.Drug;
import lm.evaluation.project.model.untaxable.Food;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 16/02/2018
 */
public class Input3 {
	
	@Test
	public void Input3Chart() {
		BigDecimal expectedTotalPrice = new BigDecimal(74.68).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotalTaxes = new BigDecimal(6.70).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("Input3:");
		Cosmetic c1 = new Cosmetic("bottle of perfume",1,(float)27.99,true);
		Cosmetic c2 = new Cosmetic("bottle of perfume",1,(float)18.99,false);
		Drug d = new Drug("packet of headache pills",1,(float)9.75,false);
		Food f = new Food("box of chocolates", 1, (float)11.25,true);
		System.out.println(c1.toStringWithoutTaxes());
		System.out.println(c2.toStringWithoutTaxes());
		System.out.println(d.toStringWithoutTaxes());
		System.out.println(f.toStringWithoutTaxes());
		System.out.println("Output1:");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(d.toString());
		System.out.println(f.toString());
		BigDecimal totalTaxes = c1.getTotalTaxes()
				.add(c2.getTotalTaxes())
				.add(d.getTotalTaxes())
				.add(f.getTotalTaxes());
		BigDecimal totalPrice = c1.getTotalPrice()
				.add(c2.getTotalPrice())
				.add(d.getTotalPrice())
				.add(f.getTotalPrice());
		System.out.println("Sales Taxes: "+totalTaxes);
		System.out.println("Total: "+totalPrice);
		Assert.assertTrue(totalTaxes.equals(expectedTotalTaxes));
		Assert.assertTrue(totalPrice.equals(expectedTotalPrice));
	}
}
