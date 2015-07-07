package bjc.payroll;

// A line on a pay stub
public class PayLine {
	// The amount added/subtracted to the total
	private int amount;
	
	// Does this amount count towards the total
	private boolean isTotaling;
	
	// The description of this pay item
	private String description;
}
