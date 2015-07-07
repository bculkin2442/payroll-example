package bjc.payroll;

// Class to hold an float
public class FloatHolder {
	private float f;
	
	// Create a new float holder
	public FloatHolder(float f) {
		this.setFloat(f);
	}

	// Get the held float
	public float getFloat() {
		return f;
	}

	// Set the held float
	public void setFloat(float f) {
		this.f = f;
	}
	
	// Add an amount to the held float, returning the new value
	public float addToFloat(float f) {
		this.f += f;
		return f;
	}
}
