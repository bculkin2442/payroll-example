package bjc.payroll;

// A line on a pay stub
public class PayLine {
	// The amount added/subtracted to the total
	private float amount;
	
	// Does this amount count towards the total
	private boolean isTotaling;
	
	// The description of this pay item
	private String description;

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * @return the isTotaling
	 */
	public boolean isTotaling() {
		return isTotaling;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public PayLine(float amount, boolean isTotaling, String description) {
		this.amount = amount;
		this.isTotaling = isTotaling;
		this.description = description;
	}
	
}
