package lm.evaluation.project;

import lm.evaluation.project.model.base.Item;
import lm.evaluation.project.model.taxable.Audio;
import lm.evaluation.project.model.taxable.Cosmetic;
import lm.evaluation.project.model.taxable.HighTech;
import lm.evaluation.project.model.untaxable.Book;
import lm.evaluation.project.model.untaxable.Drug;
import lm.evaluation.project.model.untaxable.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author tobia.moretti
 * @date 13/02/2018
 * @description demo of a simplified console application for dynamic testing
 */
//TODO better insert a logger instead of System.out ... this is just a demo
public class LmEval {
	public static void main(String[] args) throws IOException {
	
		System.out.println("Generating products for simulation ...");
		Map<Integer,Item> products = generate();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer,Item> userChoice = new HashMap<>();
		String userInput = "";
		while(!userInput.equals("N")) {
			
			System.out.println("Check product list and make your choice.");
			for (Map.Entry<Integer, Item> p : products.entrySet()) {
				if (!userChoice.containsKey(p.getKey())) {
					System.out.println(p.getKey() + " - " + p.getValue().toStringWithoutTaxes());
				}
			}
			while (!userInput.equals("DONE")) {
				System.out.println("Please, insert ONLY the number of the item: ");
				try{
					Integer key = Integer.parseInt(br.readLine());
					if (key >= 1 && key <= 11) {
						System.out.println("Please, insert the requested quantity: ");
						Integer quantity = Integer.parseInt(br.readLine());
						Item choicedItem = products.get(key);
						choicedItem.setQuantity(quantity);
						userChoice.put(key,choicedItem);
						userInput = "DONE";
					}
				}catch(NumberFormatException nfe){
					System.err.println("Invalid Format!");
				}
			}
			while(!userInput.equals("Y") && !userInput.equals("N")) {
				System.out.println("Did you want to choice another product? (Y/N)");
				userInput = br.readLine().toUpperCase();
			}
		}
		System.out.println("Checking chart content...");
		System.out.println("-------------------------");
		System.out.println("-------- CHART ----------");
		System.out.println("-------------------------");
		BigDecimal totalPrice = BigDecimal.valueOf(0.00);
		BigDecimal totalTaxes = BigDecimal.valueOf(0.00);
		for (Item i : userChoice.values()) {
			System.out.println(i.toString());
			totalPrice = totalPrice.add(i.getTotalPrice());
			totalTaxes = totalTaxes.add(i.getTotalTaxes());
		}
		System.out.println("Sales Taxes: "+totalTaxes);
		System.out.println("Total: "+totalPrice);
		System.out.println("-------------------------");
		System.out.println("--------  END  ----------");
		System.out.println("-------------------------");
		
	}
	
	private static Map<Integer,Item> generate() {
		Map<Integer,Item> products = new HashMap<>();
		
		/* BOOKS */
		Book b1 = new Book("book", 1, (float)22.49, true);
		b1.setAuthor("Valerio Massimo Manfredi");
		b1.setTitle("Lo scudo di Talos");
		b1.setLanguage("ITA");
		Book b2 = new Book("book", 1, (float)10.62, false);
		b2.setAuthor("Licia Troisi");
		b2.setTitle("Nihal della Terra del Vento");
		b2.setIsbnCode("9788532520036");
		/* DRUGS */
		Drug d1 = new Drug("box of pils", 1, (float)6.99, false);
		d1.setPharmaceuticalIndustry("Bayer");
		d1.setName("VIVIN C");
		d1.setNeedPrescription(false);
		/* FOODS */
		Food f1 = new Food("apples", 1, (float)1.58,true);
		try {
			f1.setExpirationDate(new SimpleDateFormat("dd-MM-yyyy", Locale.ITALIAN).parse("15-02-2018"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		f1.setTypology("unpackaged");
		Food f2 = new Food("chocolates", 1, (float)8.67,false);
		try {
			f2.setExpirationDate(new SimpleDateFormat("dd-MM-yyyy", Locale.ITALIAN).parse("29-12-2018"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		f2.setTypology("box of ");
		/* AUDIO */
		Audio a1 = new Audio("Vynile", 1, (float)52.43, true);
		a1.setAuthor("Metallica");
		a1.setTitle("Master of Puppets");
		a1.setRecordIndustry("Elektra Records");
		a1.setTypology("Heavy Metal");
		Audio a2 = new Audio("Music CD", 1, (float)22.00, true);
		a2.setAuthor("Ed Sheeran");
		a2.setTitle("Divide");
		a2.setRecordIndustry("Atlantics Records");
		a2.setTypology("Pop Folk");
		/* COSMETICS */
		Cosmetic c1 = new Cosmetic("cream", 1, (float)3.43, false);
		c1.setName("Soft");
		c1.setCosmeticIndustry("Nivea");
		c1.setQuantityOfProduct("300ml");
		Cosmetic c2 = new Cosmetic("deodorant", 1, (float)2.90, false);
		c2.setName("Original");
		c2.setCosmeticIndustry("Dove");
		c2.setTypology("spray");
		/* HIGH TECH */
		HighTech h1 = new HighTech("", 1, (float)799.89, false);
		h1.setBrand("ASUS");
		h1.setName("ZenBook Pro Serie UX550VD");
		h1.setTypology("ultrabook");
		HighTech h2 = new HighTech("desktop", 1, (float)3899.00, true);
		h2.setBrand("DELL");
		h2.setName("Alienware Area 51");
		
		products.put(1,a1);
		products.put(2,a2);
		products.put(3,b1);
		products.put(4,b2);
		products.put(5,c1);
		products.put(6,c2);
		products.put(7,d1);
		products.put(8,f1);
		products.put(9,f2);
		products.put(10,h1);
		products.put(11,h2);
		return products;
	}
}