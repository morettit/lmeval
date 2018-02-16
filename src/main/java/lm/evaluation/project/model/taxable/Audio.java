package lm.evaluation.project.model.taxable;

import lm.evaluation.project.model.base.TaxableItem;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class Audio extends TaxableItem {
	
	private String title;
	private String author;
	private String typology;
	private String recordIndustry;
	
	public Audio(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public String getTitle() {
		return title;
	}
	
	public Audio setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Audio setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	public String getTypology() {
		return typology;
	}
	
	public Audio setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	
	public String getRecordIndustry() {
		return recordIndustry;
	}
	
	public Audio setRecordIndustry(String recordIndustry) {
		this.recordIndustry = recordIndustry;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Audio audio = (Audio) o;
		
		if (getTitle() != null ? !getTitle().equals(audio.getTitle()) : audio.getTitle() != null) return false;
		if (getAuthor() != null ? !getAuthor().equals(audio.getAuthor()) : audio.getAuthor() != null) return false;
		if (getTypology() != null ? !getTypology().equals(audio.getTypology()) : audio.getTypology() != null)
			return false;
		return getRecordIndustry() != null ? getRecordIndustry().equals(audio.getRecordIndustry()) : audio.getRecordIndustry() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getTitle() != null ? getTitle().hashCode() : 0;
		result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
		result = 31 * result + (getTypology() != null ? getTypology().hashCode() : 0);
		result = 31 * result + (getRecordIndustry() != null ? getRecordIndustry().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getTitle()))
				.append(evaluateBlank("by",getAuthor()))
				.append(evaluateBlank("with",getRecordIndustry()))
				.append(" at ")
				.append(getTotalPrice())
				.toString();
	}
	
	public String toStringWithoutTaxes() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getTypology()))
				.append(evaluateBlank(getTitle()))
				.append(evaluateBlank("by",getAuthor()))
				.append(evaluateBlank("with",getRecordIndustry()))
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
