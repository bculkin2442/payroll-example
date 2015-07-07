package bjc.payroll;

import java.util.List;
import java.util.Map;

// A role an employee has for pay purposes
public interface Role {
	// Get the unique ID used to identify this role
	public int getID();
	
	// The order to process this role in.
	//  0 is first, and roles of the same priority are applied
	//  in an unspecified order
	int getPriority();
	
	// Should this role be counted towards the pay total?
	//	Used for things like subtotals
	boolean isNonTotaling();
	
	// Get the description of what this role is
	public String description();
	
	// Calculate the amount for this role on a particular employee
	//	
	// A return of zero means that this role will be disregarded
	//	and not added to the payroll.
	//	
	// The map is all of the existing pay items. This is strictly less efficent than
	//	just passing the list of built paylines, but I believe ease of access is more 
	//	important here. The key is the role ID.
	//
	// The amount is the current total so far.
	public float calculate(Employee em, Map<Integer, PayLine> lpl, float amt);
}
