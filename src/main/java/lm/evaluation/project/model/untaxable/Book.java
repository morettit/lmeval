package lm.evaluation.project.model.untaxable;

import lm.evaluation.project.model.base.UntaxableItem;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class Book extends UntaxableItem {
	
	private String language;
	private String title;
	private String author;
	private String isbnCode;
	
	public Book(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public String getLanguage() {
		return language;
	}
	
	public Book setLanguage(String language) {
		this.language = language;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Book setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	public String getIsbnCode() {
		return isbnCode;
	}
	
	public Book setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Book book = (Book) o;
		
		if (getLanguage() != null ? !getLanguage().equals(book.getLanguage()) : book.getLanguage() != null)
			return false;
		if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
		if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
		return getIsbnCode() != null ? getIsbnCode().equals(book.getIsbnCode()) : book.getIsbnCode() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getLanguage() != null ? getLanguage().hashCode() : 0;
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
		result = 31 * result + (getIsbnCode() != null ? getIsbnCode().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getTitle()))
				.append(evaluateBlank(getLanguage()))
				.append(evaluateBlank(getAuthor()))
				.append(evaluateBlank("ISBN", getIsbnCode()))
				.append(" at ")
				.append(getTotalPrice())
				.toString();
	}
	
	public String toStringWithoutTaxes() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getTitle()))
				.append(evaluateBlank(getLanguage()))
				.append(evaluateBlank(getAuthor()))
				.append(evaluateBlank("ISBN", getIsbnCode()))
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
