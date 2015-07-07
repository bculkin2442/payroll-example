package bjc.payroll;

// A role an employee has for pay purposes
public interface Role {
	// The order to process this role in.
	//  0 is first, and roles of the same priority are applied
	//  in an unspecified order
	int getPriority();
	
	// Should this role be counted towards the pay total?
	//	Used for things like subtotals
	boolean isNonTotaling();
	
	
}
