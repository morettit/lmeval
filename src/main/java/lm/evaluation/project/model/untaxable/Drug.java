package lm.evaluation.project.model.untaxable;

import lm.evaluation.project.model.base.UntaxableItem;

import static lm.evaluation.project.utils.Utils.evaluateBlank;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 */
public class Drug extends UntaxableItem {
	
	private String name;
	private double dose;
	private String unity;
	private boolean needPrescription;
	private String pharmaceuticalIndustry;
	
	public Drug(String description, int quantity, float price, boolean imported) {
		super(description, quantity, price, imported);
	}
	
	public String getName() {
		return name;
	}
	
	public Drug setName(String name) {
		this.name = name;
		return this;
	}
	
	public double getDose() {
		return dose;
	}
	
	public String getDoseAsString() {
		return dose > 0 ? String.valueOf(dose) : null;
	}
	
	public Drug setDose(double dose) {
		this.dose = dose;
		return this;
	}
	
	public String getUnity() {
		return unity;
	}
	
	public Drug setUnity(String unity) {
		this.unity = unity;
		return this;
	}
	
	public boolean isNeedPrescription() {
		return needPrescription;
	}
	
	public Drug setNeedPrescription(boolean needPrescription) {
		this.needPrescription = needPrescription;
		return this;
	}
	
	public String getPharmaceuticalIndustry() {
		return pharmaceuticalIndustry;
	}
	
	public Drug setPharmaceuticalIndustry(String pharmaceuticalIndustry) {
		this.pharmaceuticalIndustry = pharmaceuticalIndustry;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Drug drug = (Drug) o;
		
		if (Double.compare(drug.getDose(), getDose()) != 0) return false;
		if (isNeedPrescription() != drug.isNeedPrescription()) return false;
		if (getName() != null ? !getName().equals(drug.getName()) : drug.getName() != null) return false;
		if (getUnity() != null ? !getUnity().equals(drug.getUnity()) : drug.getUnity() != null) return false;
		return getPharmaceuticalIndustry() != null ? getPharmaceuticalIndustry().equals(drug.getPharmaceuticalIndustry()) : drug.getPharmaceuticalIndustry() == null;
	}
	
	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getName() != null ? getName().hashCode() : 0;
		temp = Double.doubleToLongBits(getDose());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (getUnity() != null ? getUnity().hashCode() : 0);
		result = 31 * result + (isNeedPrescription() ? 1 : 0);
		result = 31 * result + (getPharmaceuticalIndustry() != null ? getPharmaceuticalIndustry().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getPharmaceuticalIndustry()))
				.append(evaluateBlank(getName()))
				.append(evaluateBlank(getDoseAsString()))
				.append(evaluateBlank(getUnity()))
				.append(" at ")
				.append(getTotalPrice())
				.toString();
	}
	
	public String toStringWithoutTaxes() {
		return new StringBuilder()
				.append(getQuantity())
				.append("x ")
				.append(evaluateBlank(getDescription()))
				.append(evaluateBlank(getPharmaceuticalIndustry()))
				.append(evaluateBlank(getName()))
				.append(evaluateBlank(getDoseAsString()))
				.append(evaluateBlank(getUnity()))
				.append(" at ")
				.append(getTotalPrice().subtract(getTotalTaxes()))
				.toString();
	}
}
