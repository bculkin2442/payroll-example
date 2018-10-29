package bjc.payroll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Calculate payroll for employees
public class PayrollCalculator {
	// Calculate & print payroll for an employee
	public void calculate(Employee e) {
		// Print out the header
		System.out.println("Payroll for Employee: " + e.getName());
		PayHours hours = e.getHours();
		System.out.println("Hours Worked: " + hours.getHours());
		if (hours.getOvertime() != 0) {
			System.out.println("Overtime Worked: " + hours.getOvertime());
		}

		// Print a spacer
		System.out.println("--------------------------------------------");

		// Now begins the actual calculation of pay.
		// It's assumed the highest priority role gives the base pay

		// The current total
		float amt = 0;

		Iterator<Role> roleIt = e.getRoles().iterator();

		// The current set of paylines that've been set
		Map<Integer, PayLine> lpl = new HashMap<>();

		// Calculate base pay
		Role base = roleIt.next();
		amt += base.calculate(e, lpl, amt);
		System.out.println(base.description() + "\t\t" + amt);

		// Add a payline to the map
		lpl.put(base.getPriority(), new PayLine(amt, true, base.description()));

		for (Role r : roleIt) {
			// Calculate the role first
			float am = r.calculate(e, lpl, amt.getFloat());

			// Only do stuff if its non-zero
			if (am != 0) {
				// Handle non-totaling roles
				if (r.isNonTotaling()) {
					System.out.println("* " + r.description() + 
							"\t\t" + am);
				} else {
					amt += am;
					
					System.out.println(r.description() + 
							"\t\t" + amt);
				}

				// Add the role to the list
				lpl.put(r.getPriority(), 
						new PayLine(amt, r.isNonTotaling(),
								r.description()));

			}
		}
		

		// Print a spacer
		System.out.println("--------------------------------------------");
		
		// Print out the total
		System.out.println("Total: \t\t" + amt);
	}
}
