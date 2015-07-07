package bjc.payroll;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.management.ImmutableDescriptor;

public class Employee {
	// All of the roles this employee is in.
	//	Sorted by their payment priority
	private SortedSet<Role> roles;
	
	// The name of this employee
	private String name;
	
	// The hours/overtime worked by this employee
	private PayHours hours;
	
	// Create a new employee
	public Employee(String name, int regHours, int overtime, Role... rles) {
		this.name = name;
		this.hours = new PayHours(regHours, overtime);
		this.roles = new TreeSet<>(new RoleComparator());
		this.roles.addAll(Arrays.asList(rles));
	}
	
	// Create a new employee who doesn't work overtime
	public Employee(String name, int regHours, Role... rles) {
		this(name, regHours, 0, rles);
	}
	
	// Add a role to an employee
	public void addRole(Role rl) {
		roles.add(rl);
	}
	
	// Remove a role from an employee
	public void removeRole(Role rl) {
		roles.remove(rl);
	}
	
	// Get all of the roles this employee has
	//	The returned set is immutable
	public Set<Role> getRoles() {
		return Collections.unmodifiableSortedSet(roles);
	}
}
