package bjc.payroll;

import java.util.Comparator;

public class RoleComparator implements Comparator<Role> {

	@Override
	public int compare(Role o1, Role o2) {
		return o1.getPriority() - o2.getPriority();
	}

}
