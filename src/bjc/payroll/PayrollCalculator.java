package bjc.payroll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

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
		FloatHolder amt = new FloatHolder(0);

		Iterator<Role> roleIt = e.getRoles().iterator();

		// The current set of paylines that've been set
		Map<Integer, PayLine> lpl = new HashMap<>();

		// Calculate base pay
		Role base = roleIt.next();
		amt.addToFloat(base.calculate(e, lpl, amt.getFloat()));
		System.out.println(base.description() + "\t\t" + amt);

		// Add a payline to the map
		lpl.put(base.getPriority(), new PayLine(amt.getFloat(), true, base.description()));

		// Handle the rest of the roles
		roleIt.forEachRemaining(new Consumer<Role>() {

			@Override
			public void accept(Role r) {
				// Calculate the role first
				float am = r.calculate(e, lpl, amt.getFloat());

				// Only do stuff if its non-zero
				if (am != 0) {
					// Handle non-totaling roles
					if (r.isNonTotaling()) {
						System.out.println("* " + r.description() + 
								"\t\t" + am);
					} else {
						System.out.println(r.description() + 
								"\t\t" + amt.addToFloat(am));
					}
					
					// Add the role to the list
					lpl.put(r.getPriority(), 
							new PayLine(amt.getFloat(), r.isNonTotaling(),
									r.description()));

				}
			}

		});
		

		// Print a spacer
		System.out.println("--------------------------------------------");
		
		// Print out the total
		System.out.println("Total: \t\t" + amt.getFloat());
	}
}
