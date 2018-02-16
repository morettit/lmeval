import lm.evaluation.project.model.taxable.Audio;
import lm.evaluation.project.model.untaxable.Book;
import lm.evaluation.project.model.untaxable.Food;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author tobia.moretti
 * @date 16/02/2018
 */
public class Input1 {
	
	@Test
	public void Input1Chart() {
		BigDecimal expectedTotalPrice = new BigDecimal(29.83).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotalTaxes = new BigDecimal(1.50).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("Input1:");
		Book b = new Book("book",1,(float)12.49,false);
		Audio a = new Audio("music CD", 1, (float)14.99,false);
		Food f = new Food("chocolate bar", 1, (float)0.85,false);
		System.out.println(b.toStringWithoutTaxes());
		System.out.println(a.toStringWithoutTaxes());
		System.out.println(f.toStringWithoutTaxes());
		System.out.println("Output1:");
		System.out.println(b.toString());
		System.out.println(a.toString());
		System.out.println(f.toString());
		BigDecimal totalTaxes = b.getTotalTaxes()
				.add(a.getTotalTaxes())
				.add(f.getTotalTaxes());
		BigDecimal totalPrice = b.getTotalPrice()
				.add(a.getTotalPrice())
				.add(f.getTotalPrice());
		System.out.println("Sales Taxes: "+totalTaxes);
		System.out.println("Total: "+totalPrice);
		Assert.assertTrue(totalTaxes.equals(expectedTotalTaxes));
		Assert.assertTrue(totalPrice.equals(expectedTotalPrice));
	}
}
