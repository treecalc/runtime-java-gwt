package treecalc.rt.gwt;

public class DecimalFormatSymbols {
	private char decimalSeparator = '.';
	private char groupingSeparator = '\0';
	
	public DecimalFormatSymbols() {}

	public char getDecimalSeparator() {
		return decimalSeparator;
	}
	public void setDecimalSeparator(char decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public char getGroupingSeparator() {
		return groupingSeparator;
	}

	public void setGroupingSeparator(char groupingSeparator) {
		this.groupingSeparator = groupingSeparator;
	}
}
